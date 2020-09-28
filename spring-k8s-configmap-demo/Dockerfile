FROM centos:7

MAINTAINER wangjq <wangjq@primeton.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ENV LANG en_US.utf8
ENV LC_ALL en_US.utf8

ADD jdk-8u261-linux-x64.tar.gz /usr/local/

ENV JAVA_HOME /usr/local/jdk1.8.0_261
ENV CLASSPATH $JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV PATH $PATH:$JAVA_HOME/bin

COPY ./target/demo-1.0.jar /opt

WORKDIR /opt

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-1.0.jar"]

