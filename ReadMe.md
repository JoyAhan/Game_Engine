# Project Odyssey - Game Engine

This project implements a simple text-based adventure game engine in Java that allows players to explore interconnected rooms using text commands. The core components are:

- **Room:** Represents a location in the game with an ID, name, description, and available exits.
- **GameWorld:** Manages the game state including rooms and player's current location.
- **Command:** An interface for executable game actions (e.g., "go", "look", "help").
- **CommandRegistry:** Handles command registration and execution based on user input.
- **Main:** The entry point that initializes the game world and runs the main game loop.

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
    M->>GW: Initialize GameWorld
    loop Game Loop
        M->>GW: Get Current Room
        GW-->>M: Room Info
        M->>M: Display Room Info
        M->>M: Get User Input
        M->>CR: Get Command
        alt Command Found
            CR-->>M: Command Object
            M->>C: Execute(GameWorld, argument)
            C->>GW: Perform Action
            GW-->>C: Action Result
            C-->>M: Execution Complete
        else Command Not Found
            CR-->>M: Empty Optional
            M->>M: Display "Unknown Command"
        end
    end
```
