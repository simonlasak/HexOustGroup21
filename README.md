# HexOust – Game Instructions

**HexOust** is a strategic board game played on a hexagonal grid where two players (Red and Blue) take turns placing hexagons to capture their opponent's pieces.  

We developed this game as part of the *Software Engineering Project II* module with two classmates — and received an **A+ grade**.

---

## How to Launch the Game

### System Requirements
- Java **11** or later  
- At least **4 GB RAM**  
- Screen resolution **1024×768** or higher  

### Running the Game
1. Download the `HexOust.jar` file  
2. Run it in one of these ways:
   - **Double-click** the JAR file  
   - Or from terminal / command prompt:  
     ```bash
     java -jar HexOust.jar
     ```
   - If JavaFX is not included in your setup, run:  
     ```bash
     java --module-path [path-to-javafx-lib] \
          --add-modules javafx.controls,javafx.fxml \
          -jar [path-to-HexOust.jar]
     ```
     Example:
     ```bash
     java --module-path /home/david/ctfTools/javafx-sdk-23.0.2/lib \
          --add-modules javafx.controls,javafx.fxml \
          -jar HexOust.jar
     ```

---

## How to Play

### Objective
Capture **all of your opponent's stones** on the board.

### Rules
1. **Setup:** The board starts empty. The **Red** player moves first.  
2. **Turns:** Players alternate placing one hexagon of their color.  
3. **Placement Rules:**
   - You **cannot** place adjacent to your own color (unless capturing).  
   - You **can** place adjacent to your opponent's color.  
   - You **can** place in empty spaces not touching any hexagon.  
4. **Capturing:**
   - Groups = connected hexagons of the same color.  
   - If your group is **larger** than an adjacent opponent’s group, you capture it.  
   - Captured groups are removed from the board.  
5. **Special Cases:**
   - After a successful capture, the same player gets another turn.  
   - A player cannot make a move that would leave them with no hexagons.  

---

## Game Controls
- **Place Hexagon:** Click an empty hex space  
- **Restart Game:** Click **Play Again** or the bottom-left reset button  
- **Exit Game:** Click **Quit** (anytime or after a match)  

---

## Interface Elements
- **Turn Indicator:** Shows whose turn it is (top-right corner)  
- **Hexagon Highlighting:** Valid moves glow when hovered  
- **Victory Animation:** Plays when a player wins 🎉  

---

## Learn More
For additional information, see: [HexOust – Mindsports article](https://mindsports.nl/index.php/the-pit/614-hexoust)  

---
 Enjoy playing **HexOust**!
