/*
  ******************************************************************************
  * Copyright 2018, Oath Inc.
  * Licensed under the terms of the Apache Version 2.0 license.
  * See LICENSE file in project root directory for terms.
  ******************************************************************************
*/

package com.aol.one.dwh.infra.sql

import java.sql.ResultSet
import org.apache.commons.dbutils.ResultSetHandler
import scalaz.syntax.std.boolean._

class LongValueResultHandler extends ResultSetHandler[Option[Long]] {

  private val VALUE_INDEX = 1

  override def handle(resultSet: ResultSet): Option[Long] = {
    resultSet.next()
      .option(resultSet)
      .flatMap(rs => Option(rs.getObject(VALUE_INDEX))
        .map(_ => rs.getLong(VALUE_INDEX)))
  }
}
