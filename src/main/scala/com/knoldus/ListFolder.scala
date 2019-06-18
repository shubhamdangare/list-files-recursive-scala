package com.knoldus

import java.io.File

import scala.concurrent.Future

class ListFolder(dirName: String) {

  def getListOfAllFilesInAllSubDirectories(dir: Array[File], index: Int, level: Int, count: Int): Future[Int] = {

    var cnt = count
    if (dir.length == index) {
      return Future.successful(cnt)
    }

    if (dir(index).isFile) {
      cnt =   cnt + 1
    }
    else if (dir(index).isDirectory) {
      getListOfAllFilesInAllSubDirectories(dir(index).listFiles, 0, level + 1 ,cnt)

    }

    getListOfAllFilesInAllSubDirectories(dir, index + 1, level,cnt)

  }


  def getListOfFiles(): Future[Any] = {

    val d = new File(dirName)
    if (d.exists && d.isDirectory) {
      getListOfAllFilesInAllSubDirectories(d.listFiles(), 0, 0 , 0)
    }
    else {
      Future.successful(-1 )
    }

  }
}
