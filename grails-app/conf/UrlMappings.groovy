class UrlMappings {
    static mappings = {


      "/start/$id?" {
        controller = "dashboard"
      }

	  "/login/$action?/$id?" {
		controller = "login"
	  }

	  "/logout" {
		  controller = "logout"
      action = "index"
	  }


      "/admin/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
      "/"(view:"/index")
	  "500"(view:'/error')
	}
}
