package de.uenterprise.ep


/**
 * initializes and caches often used parameter objects
 */
class DefaultObjectService {
    def   sessionFactory
    def   entityHelperService
    def   defaultObjectService

    boolean transactional = false

    def bootstrapData() {
      onEmptyDatabase {
        makeUserEntities()
      }
    }

    def onEmptyDatabase (Closure c) {
      if (!EpSystem.count()) {
        log.warn ("emtpy database. will install demo data set")
        new EpSystem(sysKey:"SCHEMA_VERSION", sysVal:"0").save()
        if (c) c.call()
        sessionFactory.currentSession.flush()
      }
    }

  def makeUserEntities() {
    // create security roles (needed for user creation)
    new Role(authority:"ROLE_USER", description:"regular user").save()
    new Role(authority:"ROLE_VIP", description:"user with some extra privileges").save()
    new Role(authority:"ROLE_ADMIN", description:"system administrator").save()
    sessionFactory.currentSession.flush()


    // create some entities, types and supertypes
    log.debug ("start creating entity metadata structure")
    EntitySuperType estPerson = new EntitySuperType(name:"Person", profileType:'Person')
      EntityType etKrocher = new EntityType (name:"Krocher")
      estPerson.addToEntityTypes (etKrocher)
      EntityType etRocker = new EntityType (name:"Rocker")
      estPerson.addToEntityTypes (etRocker)
      EntityType etEmo = new EntityType (name:"Emo")
      estPerson.addToEntityTypes (etEmo)

    if (!estPerson.save()) {
      estPerson.errors.each {
        log.error ("Bootstrap Error: $it")
      }
      throw new IllegalArgumentException("failed to bootstrap entity structure metadata")
    }
    sessionFactory.currentSession.flush()
    log.debug ("entity structure created successfully")



    // create some actual entities
    entityHelperService.createEntityWithUserAndProfile ("franz", etKrocher, "franz@bbb.com", "Franz Franz and the Melody Boys") {Entity it->
      it.profile.tagline = "to be on top is our job"
      it.profile.gender = 1 ;
    }

    entityHelperService.createEntityWithUserAndProfile("detlef", etEmo, "detleft@aon.at", "Captain Sensible") {Entity ent->
      def admin = Role.findByAuthority("ROLE_ADMIN")
      assert admin
      ent.user.addToAuthorities (admin)
    }


    entityHelperService.createEntityWithUserAndProfile("hugo", etRocker, "karwall@bxlxax.fr", "Hugo Tester")
    entityHelperService.createEntityWithUserAndProfile("otto", etRocker, "ottor@bulag.net", "Otto R. Kaputnik")

  }

}
