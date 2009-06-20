dataSource {
	pooled = false
  driverClassName = "org.postgresql.Driver"
  username = "xxxx"
  password = "xxxx"
}

hibernate {
    cache.use_second_level_cache=true
    cache.use_query_cache=true
    cache.provider_class='com.opensymphony.oscache.hibernate.OSCacheProvider'
}
// environment specific settings
environments {
	development {
		dataSource {
      dbCreate = "create-drop" // one of 'create', 'create-drop','update'
      url = "jdbc:postgresql://localhost:5432/ue-dev"
//      loggingSql = true
      hibernate.default_schema = 'ubasedev'
      username = "postgres"
      password = "postgres"
		}
	}
	test {
    dataSource {
      dbCreate = "create-drop" // one of 'create', 'create-drop','update'
      url = "jdbc:postgresql://localhost:5432/ue-dev"
      loggingSql = true
      hibernate.default_schema = 'ubasedev'
      username = "postgres"
      password = "postgres"
    }
	}
	production {
		dataSource {
      dbCreate = "create-drop" // one of 'create', 'create-drop','update'
      url = "jdbc:postgresql://smv1.softmachine.at:5432/xxxx"
      loggingSql = true
      hibernate.default_schema = 'prod_xxxx'
		}
	}
}