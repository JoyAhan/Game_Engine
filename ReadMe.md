# Project Odyssey - Game Engine

This project implements a simple text-based adventure game engine in Java. The core components are:

- **Room:** Represents a location in the game, with a description and exits.
- **GameWorld:** Manages the collection of rooms and the player's current location.
- **Command:** An interface for executable actions (e.g., "go north").
- **CommandRegistry:** Registers and retrieves commands based on user input.
- **Main:** The entry point, handles game initialization and the main game loop.

## Class Diagram

```mermaid
classDiagram
    class Main {
        +main(String[] args)
        +displayCurrentRoom(GameWorld gameWorld)
    }
    class Room {
        +id: String
        +name: String
        +description: String
        +exits: Map<String, String>
    }
    class GameWorld {
        -rooms: Map<String, Room>
        -currentRoomId: String
        +GameWorld(Map<String, Room> rooms, String currentRoomId)
        +getCurrentRoom(): Room
        +moveTo(String direction): boolean
    }
    class Command {
        <<interface>>
        +execute(GameWorld gameWorld, String argument)
    }
    class CommandRegistry {
        -commands: Map<String, Command>
        +CommandRegistry()
        +registerCommand(String name, Command command)
        +getCommand(String name): Optional<Command>
    }
    class GoCommand {
        +execute(GameWorld gameWorld, String argument)
    }

    Main --* GameWorld : creates
    GameWorld --* Room : contains
    Main --* CommandRegistry : uses
    CommandRegistry --* Command : contains
    GoCommand --|> Command : implements

```

## Sequence Diagram - Game Loop

```mermaid
sequenceDiagram
    participant M as Main
    participant CR as CommandRegistry
    participant C as Command
    participant GW as GameWorld

    M->>CR: Create CommandRegistry
    M->>M: Initialize GameWorld
    loop Game Loop
        M->>M: Display Current Room
        M->>M: Get User Input
        M->>CR: Get Command(input)
        alt Command Present
            CR-->>M: Command
            M->>C: Execute Command(GameWorld, argument)
            C->>GW: Perform Action
            GW-->>C: Result
            C-->>M:
        else Command Not Present
            CR-->>M: Empty
            M->>M: Display "Unknown Command"
        end
    end
```
