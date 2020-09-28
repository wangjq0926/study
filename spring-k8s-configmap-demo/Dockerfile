FROM huwanyang168/centos7_jdk8:v1.2

MAINTAINER wangjq <wangjq@primeton.com>

RUN ln -sf /usr/share/zoneinfo/Asia/Shanghai /etc/localtime

ADD demo-1.0.jar /opt

WORKDIR /opt

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "demo-1.0.jar"]

