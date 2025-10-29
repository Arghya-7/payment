document.addEventListener("DOMContentLoaded", () => {
    const form = document.getElementById("paymentForm");
  
    form.addEventListener("submit", async function (event) {
      event.preventDefault();
  
      const formData = {
        reference: document.getElementById("reference").value,
        amount: {
          currency: document.getElementById("currency").value,
          value: parseInt(document.getElementById("value").value)
        },
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
        onPaymentCompleted: (result, component) => {
          console.log(result);
          pspId = result.pspReference;
          console.log("PSP Reference:", result.pspReference);
        },
        onError: (error) => console.error("Payment Error:", error),
      });

      document.getElementById("paymentForm").style.display = "none";
    
      await checkout.create("dropin").mount("#dropin-container");
    });
  });
  