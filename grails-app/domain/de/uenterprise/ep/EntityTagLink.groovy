package de.uenterprise.ep

class EntityTagLink {
    static belongsTo = [tag : Tag]
    Entity entity
    TagLinkType type 

    static constraints = {
    }
}
