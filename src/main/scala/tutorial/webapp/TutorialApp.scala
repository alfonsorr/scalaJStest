package tutorial.webapp

import monix.execution.ExecutionModel.AlwaysAsyncExecution
import monix.execution.{CancelableFuture, Scheduler}
import monix.reactive.Observable
import org.scalajs.jquery.jQuery

import scala.concurrent.duration._

object TutorialApp {

  private lazy implicit val scheduler:Scheduler =
    Scheduler(executionModel=AlwaysAsyncExecution)

  private var button:Option[CancelableFuture[Unit]] = None

  def main(args: Array[String]): Unit = {
    jQuery(() => setupUI())
  }

  def addClickedMessage(): Unit = {
    if (button.isEmpty) {
      button = Some(Observable.interval(1 second).foreach(a =>
        jQuery("body").append(s"<p>You clicked the button!$a</p>")
      ))
    } else {
      button.foreach(_.cancel())
      button = None
    }
  }

  def setupUI(): Unit = {
    jQuery("#click-me-button").click(() => addClickedMessage())
    jQuery("body").append("<p>Hello World</p>")
  }

}
