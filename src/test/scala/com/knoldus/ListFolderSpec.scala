package com.knoldus

import org.scalatest.concurrent.ScalaFutures
import org.scalatest.mockito.MockitoSugar
import org.scalatest.{Matchers, WordSpec}

class ListFolderSpec extends WordSpec with ScalaFutures with Matchers with MockitoSugar{

  val filesPath = "/home/shubham/Desktop/work/scala-list-file/src/main/scala/com/knoldus/test"
  val fileWrongPAth = "/home/shubham/Desktop/work/scala-list-file/src/main/scala/com/knoldus/test1"

  protected val listFolder: ListFolder = new ListFolder(filesPath)
  protected val wrongPathFolder: ListFolder = new ListFolder(fileWrongPAth)


  "ListService#ListAllFiles" should {
    "list all files successfully" in {
      whenReady(listFolder.getListOfFiles())(_ shouldBe 1)
    }

    "not list for wrong path" in {

      whenReady(wrongPathFolder.getListOfFiles())(_ shouldBe -1)
    }

  }
}
