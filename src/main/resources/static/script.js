const paymentOption = null;

document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("paymentForm");
  
    form.addEventListener("submit", async function (event) {
      event.preventDefault();
      const urlParams = new URLSearchParams(window.location.search);
      const method = urlParams.get("method");
      const formData = {
        reference: document.getElementById("reference").value,
        amount: {
          currency: document.getElementById("currency").value,
          value: parseInt(document.getElementById("value").value)
        },
        allowedPaymentMethods: [method],
        countryCode: document.getElementById("countryCode").value,
        merchantAccount: document.getElementById("merchantAccount").value,
        shopperReference: document.getElementById("shopperReference").value,
        shopperEmail: document.getElementById("shopperEmail").value,
        returnUrl: document.getElementById("returnUrl").value
      };
      let response = await fetch("http://localhost:8001/api/adyan-payment/session", {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(formData)
      });

      const session = await response.json();


      console.log(session);
      let pspId = "";
      const checkout = await AdyenCheckout({
        environment: "test",
        clientKey: "test_QWAF47MCW5HUFFZIPBWAS72J4AITXN7M",
        session : session,
        onPaymentCompleted: async (result, component) => {
          console.log(result);
          // const adyanPaymentReaultData = await fetch(`https://checkout-test.adyen.com/v71/sessions/${session.id}?sessionResult=${result.sessionResult}`, {
          //   method: "GET",
          //     headers: {
          //     'Content-Type': 'application/json',
          //     'x-api-key': 'AQEvhmfxK4LGbRNDw0m/n3Q5qf3VfKh+LJBJV3BY0iHzyp79nlTRS0WfNNR6AZcrUasQwV1bDb7kfNy1WIxIIkxgBw==-PgMyhRwzBKY/BpOmnl/wdQ51xvSuOJQpovmko11pvPQ=-i1iW*a::ZAk]Vv&d4]H'
          //   }
          // })
          const paymentResult = await fetch("http://localhost:8001/api/adyan-payment/get-payment-details", {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({
              id: session.id,
              sessionResult : result.sessionResult
            })
          });
          const paymentResultJson =  await paymentResult.json();
          window.location.href = `result.html?status=${encodeURIComponent(paymentResultJson.payments.resultCode)}`;
        },
        onError: (error) => console.error("Payment Error:", error),
      });

      document.getElementById("paymentForm").style.display = "none";
    
      await checkout.create("dropin").mount("#dropin-container");
    });
  });
  