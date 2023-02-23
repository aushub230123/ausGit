:point_right: Setup  

https://archive.apache.org/dist/kafka/2.4.0/kafka_2.12-2.4.0.tgz

:keyboard: **Kafka cluster with single node**  

1. Zookeeper instance (new terminal)  
.\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
2. Kafka server (new terminal)  
.\bin\windows\kafka-server-start.bat .\config\server.properties
3. Create a topic (new terminal)  
.\bin\windows\kafka-topics.bat --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic testTopic  
4. Producer (new terminal)  
.\bin\windows\kafka-console-producer.bat --broker-list localhost:9092 --topic testTopic
5. Consumer (new terminal)  
.\bin\windows\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic testTopic --from-beginning

-- view topics
.\bin\windows\kafka-topics.bat --bootstrap-server localhost:9092 --describe