package com.seglo.learningspark.githubstream

import java.io.InputStream

import org.specs2.mutable.Specification

class GitHubClientSpecs extends Specification {
  "GitHubClient" should {
    "Successfully parse a GitHub /events JSON response" in {
      val stream : InputStream = getClass.getResourceAsStream("/streaming/GitHubEventsPayload.json")
      val json = scala.io.Source.fromInputStream(stream).mkString

      val g = new GitHubClient

      val events = g.createEvents(json, None)
      events.right.get.foreach(println)
      events.right.get must have size 30
    }
  }
}
