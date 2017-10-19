/*******************************************************************************
 * Copyright 2017 Akamai Technologies
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License.  You may obtain a copy
 * of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
package net.meta.cefconnector.dataaccess;

import javax.sql.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;


public enum ConnectionPool {

	INSTANCE;

	private DataSource ds = null;

	private ConnectionPool() {
		HikariConfig config = new HikariConfig();
		config.setJdbcUrl("jdbc:sqlite:cefconnector.db");
		config.setDriverClassName("org.sqlite.JDBC");
		config.setIdleTimeout(0);
		config.setAutoCommit(true);
		ds = new HikariDataSource(config);
	}

	public DataSource getDatasource() {
		return ds;
	}
}
