package at.openfactory.ep



/**
 * Authority domain class.
 */
class Role {
	static hasMany = [people: Account]
  static belongsTo = Account

	String description
	String authority

	static constraints = {
		authority(blank: false, unique: true)
		description()
	}
}
