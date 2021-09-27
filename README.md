# Bray RabbitMQ Supplier

## Overview

The purpose of this project is to provide a working example of Reactive Streams using a RabbitMQ implementation.


## Environment Configuration

### Local Docker

The application can be run locally with RabbitMQ running in a Docker container.

```cmd
docker run -d --name rabbit -h rabbit -p 5672:5672 -p 15672:15672 rabbitmq:3-management`
```

### Cloud Foundry

## References

- [Reactor RabbitMQ Streams Reference Guide](https://pivotal.github.io/reactor-rabbitmq-streams/docs/current/)
- [Reactive Spring Cloud Stream in practice](https://zlaval.medium.com/reactive-spring-cloud-stream-in-practice-9c1e31ce8650)