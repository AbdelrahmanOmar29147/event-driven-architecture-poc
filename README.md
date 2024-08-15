# event-driven-architecture-poc

A proof of concept for simple event driven architecture.

RUN: 'docker-compose up -d --build' for the local kafka instance
RUN: 'docker exec -it <container-name> bash' to enter commands within the docker container
RUN: 'kafka-topics.sh --create --topic <topic-name> --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1' to publish a topic
RUN: 'kafka-topics.sh --bootstrap-server localhost:9092 --list' to list all available topics
