/*
 * Copyright (C) Lightbend Inc. <https://www.lightbend.com>
 */
// #service-impl
package controllers

import scala.concurrent.Future

import akka.actor.ActorSystem
import example.myapp.helloworld.grpc.helloworld.AbstractGreeterServiceRouter
import example.myapp.helloworld.grpc.helloworld.HelloReply
import example.myapp.helloworld.grpc.helloworld.HelloRequest
import javax.inject.Inject
import javax.inject.Singleton

/** User implementation, with support for dependency injection etc */
@Singleton
class GreeterServiceImpl @Inject() (implicit actorSystem: ActorSystem)
    extends AbstractGreeterServiceRouter(actorSystem) {

  override def sayHello(in: HelloRequest): Future[HelloReply] = Future.successful(HelloReply(s"Hello, ${in.name}!"))

}
// #service-impl
