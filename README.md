# Tic-Tac-Toe Game 🎮

## Project Description

Tic-Tac-Toe is a classic game implemented using Java Spring Boot for the backend and Thymeleaf, HTML, and CSS for the frontend. This is a part of my internship **Task 5** for my **Future Intern** internship. The application allows users to play Tic-Tac-Toe against either another player or a computer. It includes functionalities such as making moves, checking for a winner, and restarting the game. 

## Features ✨

- **Single Player Mode**: Play against the computer 🤖
- **Two Player Mode**: Play against another player 🧑‍🤝‍🧑
- **Restart Functionality**: Restart the game anytime 🔄
- **Responsive Design**: The UI adapts to different screen sizes 📱💻
- **Real-Time Updates**: Moves and game status are updated in real-time ⚡

## Tech Stack 🛠️

- **Backend**: Java, Spring Boot
- **Frontend**: Thymeleaf, HTML, CSS, JavaScript
- **Database**: In-memory storage (no database used)
- **Dependencies**: Spring Boot, Thymeleaf, jQuery

## Installation 🚀

1. **Clone the repository**:

    ```bash
    git clone https://github.com/your-username/tic-tac-toe.git
    ```

2. **Navigate to the project directory**:

    ```bash
    cd tic-tac-toe
    ```

3. **Build the project**:

    ```bash
    ./mvnw clean install
    ```

4. **Run the application**:

    ```bash
    ./mvnw spring-boot:run
    ```

5. **Open your browser** and navigate to `http://localhost:8080/tic-tac-toe` to play the game.

## UI Screenshots 📸

### Game Board
![tik1](https://github.com/user-attachments/assets/1ec83e73-26b1-43d5-b62a-ea029109b95a)

### Game Over Screen
![tik2](https://github.com/user-attachments/assets/08b459bb-ff22-4c77-8e2d-fc3568cd362a)

## Usage 🕹️

1. **Start the Application**: Run the Spring Boot application using the command provided in the installation section.
2. **Access the Game**: Open a web browser and go to `http://localhost:8080/tic-tac-toe`.
3. **Play the Game**:
   - Click on a cell to make a move.
   - If playing against the computer, it will make a move automatically.
   - Click "Restart Game" to reset the board.

## API Endpoints 📡

- **Make a Move**:
  - **URL**: `/tic-tac-toe/makeMove/{index}`
  - **Method**: `POST`
  - **Parameters**:
    - `index` (Path Variable): The index of the cell (0-8).
    - `mode` (Request Parameter): 'single' for single player mode.

- **Restart Game**:
  - **URL**: `/tic-tac-toe/restart`
  - **Method**: `POST`

## Frontend 🎨

- **HTML**: Located in `src/main/resources/templates/index.html`
- **CSS**: Located in `src/main/resources/static/css/styles.css`
- **JavaScript**: Inline script in `index.html` for handling AJAX requests.

## Contributing 🤝

Contributions are welcome! Please open an issue or submit a pull request if you have suggestions or improvements.


## Contact 📬
For any questions or feedback, please contact me at
- **Name**: Deepak Singh
- **Email**: [deepsinghkumar01@gmail.com](mailto:deepsinghkumar01@gmail.com)
