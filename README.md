# TicTacToeGame

**Author:** Minjae Kim  
**Technologies:** Java 21, Maven, Swing, JUnit 5, Apache Derby (Embedded)

## 1. Overview
A clean and fully functional Tic-Tac-Toe game built with Java Swing and Maven.  
It supports both Human vs Human and Human vs AI modes, with two difficulty levels (Easy and Hard).  
All match results are saved automatically in an embedded Derby database, and the latest records can be viewed from the in-game menu.

## 2. How to Run
- Open the project in **NetBeans**.  
- Run the main class: `tictactoeGame.Main`.  
- The game will automatically create a local Derby database on first launch.  
No extra setup is required.

## 3. Gameplay Flow
1. Start the game → Enter player names.  
2. (Optional) Check **vs AI** and choose **AI: Easy or Hard**.  
3. Click the 3×3 buttons to play.  
4. The winner or draw will be shown when the game ends.  
5. Results are saved to the database automatically.  
6. Open **Records → Show Recent 10** to see the last ten games.

## 4. Main Features
- Human vs Human or Human vs AI  
- AI: `RandomStrategy` (Easy) and `SmartStrategy` (Hard, Minimax algorithm)  
- Results saved to Derby embedded DB (`RESULTS` table)  
- Record viewer using Swing `JTable`  
- Backup log stored in `scores.txt`

## 5. Design Patterns
- **MVC:**  
  `Board` (Model), `GameWindow` (View), `SwingTicTacToeGame` (Controller)  
- **Strategy:**  
  The AI behavior can be changed by switching between strategy classes.  
- **DAO:**  
  `ResultDAO` manages database operations, and `DatabaseManager` ensures the table exists.

## 6. Key Classes
- `Board` – Stores moves, checks wins/draws, validates input  
- `GameWindow` – Builds and updates the Swing UI (buttons, status labels, reset)  
- `SwingTicTacToeGame` – Main game logic, player turns, AI moves, and UI updates  
- `MoveStrategy`, `RandomStrategy`, `SmartStrategy` – AI behavior implementations  
- `DatabaseManager`, `ResultDAO`, `ResultDialog` – Handles Derby DB, record storage, and display

## 7. Testing
Unit tests were created using **JUnit 5** to verify the game’s logic and database functions.

- `BoardTest`: tests win conditions (row/column), draw detection, and full board  
- `SmartStrategyTest`: tests AI decision making (winning and blocking moves)  
- `ResultDAOTest`: tests database insert and fetch functionality  

To run tests: **Run → Test Project (Shift + F6)**  
All tests pass successfully (`BUILD SUCCESS`).

## 8. Build & Dependencies
- Managed with **Maven** (`pom.xml`)
- Key dependencies:
  - `org.apache.derby:derby`
  - `org.junit.jupiter:junit-jupiter` (scope: test)
- Build output:  
  `target/TicTacToeGame-1.0-SNAPSHOT.jar` after **Clean and Build**

## 9. Notes
- The Git repository was re-initialized after moving project files to a clean path.  
  Previous commits were summarized in new commit messages.  
- `.gitignore` excludes build folders (`target/`), private NetBeans files, and local Derby database files (`TicTacToeDB/`).

## 10. Development Reflection
I used ChatGPT mainly to **refactor and clean up the code** for readability and structure.  
It also helped me understand how to implement the **Minimax algorithm** for the Hard AI logic,  
especially the recursive evaluation part that determines the best move.  
All final implementations and debugging were done by me after understanding the concepts.  
The tool was helpful for clarifying syntax and improving overall code quality.
