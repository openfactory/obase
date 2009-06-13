import de.uenterprise.ep.*

class BootStrap {
    def   sessionFactory
    def   entityHelperService


     def init = { servletContext ->
       log.info ("start u/base plugin bootstrap")

       if (!EpSystem.count()) {
         log.warn ("emtpy database. will install demo data set")
         new EpSystem(sysKey:"SCHEMA_VERSION", sysVal:"0").save()

         makeUserEntities ()

         // flush session
         sessionFactory.currentSession.flush()
       }

     }

     def destroy = {
     }

  def makeUserEntities() {
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
    log.debug ("entity structure created successfully")


    // create security roles (needed for user creation)
    new Role(authority:"ROLE_USER", description:"regular user").save()
    new Role(authority:"ROLE_VIP", description:"user with some extra privileges").save()
    new Role(authority:"ROLE_ADMIN", description:"system administrator").save()

    // create some actual entities
    entityHelperService.createEntityWithUser("detlef", etKrocher, "detleft@aon.at", null)
    if (false) {
      etKrocher.addToEntities (new Entity(name:"detlef")).save()
      etKrocher.addToEntities (new Entity(name:"rod")).save()
      etKrocher.addToEntities (new Entity(name:"mary")).save()

      etRocker.addToEntities (new Entity(name:"rock")).save()
      etRocker.addToEntities (new Entity(name:"hans")).save()
      etRocker.addToEntities (new Entity(name:"smoky")).save()

      etEmo.addToEntities (new Entity(name:"kant")).save()
      etEmo.addToEntities (new Entity(name:'rollo')).save()
      etEmo.addToEntities (new Entity(name:"max")).save()
    }
  }
}