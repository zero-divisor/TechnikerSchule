# Netze

## Cisco IOS Modes

Various commands are used to move in and out of command prompts. To move from user EXEC mode to privileged EXEC mode, use the `enable` command. Use the `disable` privileged EXEC mode command to return to user EXEC mode.

__Note:__ Privileged EXEC mode is sometimes called enable mode.

To move in and out of global configuration mode, use the `configure terminal` privileged EXEC mode command. To return to the privileged EXEC mode, enter the `exit` global config mode command.

There are many different subconfiguration modes. For example, to enter line subconfiguration mode, you use the line command followed by the management line type and number you wish to access. Use the exit command to exit a subconfiguration mode and return to global configuration mode.

```
Switch> enable
Switch# configure terminal
Switch(config)# line console 0
Switch(config-line)# exit
Switch(config)#
```

To move from any subconfiguration mode of the global configuration mode to the mode one step above it in the hierarchy of modes, enter the `exit` command.

To move from any subconfiguration mode to the privileged EXEC mode, enter the `end` command or enter the key combination `Ctrl+Z`.

```
Switch(config-line)# end
Switch#
```

You can also move directly from one subconfiguration mode to another. Notice how after selecting an interface, the command prompt changes from `(config-line)#` to `(config-if)#`.

```
Switch(config-line)# interface FastEthernet 0/1
Switch(config-if)#
```