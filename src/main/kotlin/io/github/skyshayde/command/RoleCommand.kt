package io.github.skyshayde.command

import com.darichey.discord.Command
import io.github.skyshayde.AlfredBot
import sx.blah.discord.handle.obj.IRole
import sx.blah.discord.handle.obj.IUser
import java.util.*

class RoleCommand {
    private var roles: MutableMap<String, String> = HashMap()

    init {

        // TODO make this dynamic
        roles["overwatch"] = "Overwatchers"
        roles["overwatchers"] = "Overwatchers"
        roles["destiny"] = "Destineers"
        roles["destineers"] = "Destineers"
        roles["terraria"] = "Terrarians"
        roles["terrarians"] = "Terrarians"
        roles["minecraft"] = "Minecrafters"
        roles["minecrafters"] = "Minecrafters"
        roles["pokemon"] = "Pokemon"
        roles["neptunespride"] = "Neptunians"
        roles["neptunians"] = "Neptunians"
        roles["fortnite"] = "Fortniters"
        roles["fortniters"] = "Fortniters"
        roles["heroesofthestorm"] = "HOTS"
        roles["hunter"] = "Hunters"
        roles["hunters"] = "Hunters"
        roles["monsterhunter"] = "Hunters"
        roles["monsterhunterworld"] = "Hunters"
        roles["starlords"] = "Starlords"
        roles["stellaris"] = "Starlords"
        roles["smashbros"] = "smash bros"
        roles["ssb"] = "smash bros"
        val role = Command.builder()
                .onCalled { ctx ->
                    val cmdArgs = ctx.args
                    if (cmdArgs.size > 0) {
                        val role = ctx.guild.getRolesByName(roles[cmdArgs[0].toLowerCase()])[0]
                        val onoff = roleToggle(role, ctx.author)
                        ctx.channel.sendMessage("Toggling role " + role.name + (if (onoff) " on" else " off") + " for " + ctx.author.name)
                    }
                }
                .build()
        AlfredBot.registry.register(role, "role")


    }

    private fun roleToggle(role: IRole, user: IUser): Boolean {
        return if (user.hasRole(role)) {
            user.removeRole(role)
            false
        } else {
            user.addRole(role)
            true
        }
    }
}
