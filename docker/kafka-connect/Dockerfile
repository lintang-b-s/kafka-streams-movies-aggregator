FROM confluentinc/cp-kafka-connect:7.2.6



USER root
RUN yum install unzip -y


# confluentinc-kafka-connect-elasticsearch
ADD confluentinc-kafka-connect-elasticsearch-14.0.6.zip /tmp/confluentinc-kafka-connect-elasticsearch.zip
RUN unzip /tmp/confluentinc-kafka-connect-elasticsearch.zip -d /usr/share/java && rm /tmp/confluentinc-kafka-connect-elasticsearch.zip



# debezium
#https://repo1.maven.org/maven2/io/debezium/debezium-connector-postgres/2.1.0.Final/debezium-connector-postgres-2.1.0.Final-plugin.tar.gz
RUN wget https://repo1.maven.org/maven2/io/debezium/debezium-connector-postgres/2.1.0.Final/debezium-connector-postgres-2.1.0.Final-plugin.tar.gz -O /tmp/debezium-connector-postgres.tar.gz \
&& tar -xvzf /tmp/debezium-connector-postgres.tar.gz --directory /usr/share/java/ \
&& rm /tmp/debezium-connector-postgres.tar.gz



