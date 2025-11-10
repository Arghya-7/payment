Kafka Local Set up

#Start zookeeper
bin\windows\zookeeper-server-start.bat config\zookeeper.properties

#Start kafka - Run on localhost:9092
bin\windows\kafka-server-start.bat config\server.properties

#Create a topic name 'test-topic'
bin\windows\kafka-topics.bat --create --topic test-topic --bootstrap-server localhost:9092


#Verify the kafka partition
bin\windows\kafka-topics.bat --list --bootstrap-server localhost:9092

#Send message on Kafka topic
bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic test-topic

#Receive message on kafka topic
bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic test-topic --from-beginning
