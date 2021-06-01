package sample;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    // 9 переменных для кнопок (ячейки в крестиках ноликах)
    @FXML
    Button button1, button2, button3, button4, button5, button6, button7, button8, button9, button10;

    // логическая переменная flag (true- ход 1го игрока, false - ход 2го игрока)
    public Boolean flag = true;
    // переменная moves - количество ходов
    public int moves = 0;

    // основная функция осуществления хода по нажатию на кнопку
public void move(Button but){
    // если клетка пустая, только тогда можно ставить крестик или нолик
    if(but.getText().equals("")){
        moves++; // увеличиваем количество ходов
        if(flag){ // если ходит первый игрок то ставим X
            but.setText("X");
        }
        else // иначе
        {
            but.setText("0");// если ходит второй игрок то ставим 0
        }
        flag = !flag; // меняем ход игрока с 1-го на 2-го и наоборот...

        // обязательно проверяем ход на победу (вдруг уже выиграли...)
        if(checkWin()){ // если победа
            showMessage("Грандиозная победа!!!","Поздравляем вы победили!"); // вызываем всплывающее окно с текстом о Победе
            // ------------Тут нужно будет раскомментировать функцию stopGame()------------------
            //stopGame(); // вызываем функцию для остановки игры, "замораживаем" кнопки
        }
        else if(moves == 9){ // иначе, если ходов уже 9 то ничья в любом случае....
            showMessage("Боевая ничья!","Попробуйте сыграть еще одну партию..."); // Вызываем всплывающее окно с текстом о Ничье

            // ------------Тут нужно будет раскомментировать функцию stopGame()------------------
            //stopGame(); // вызываем функцию для остановки игры, "замораживаем" кнопки

        }
    }
    else // иначе, если клетка уже занята
    {
        showMessage("Неверный ход","Эта клетка занята, попробуйте другую!"); // Вызываем всплывающее окно с текстом о занятости клетки
    }

}


// вспомогательная функция для вывода всплывающих окон
public void showMessage(String s1, String s2){
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(s1);
    alert.setHeaderText(s2);
    alert.showAndWait();
}

// Функция для проверки выигрыша, не стоить вникать в сам код, но можно ознакомиться)
public Boolean checkWin(){

    if(!button1.getText().equals("")){// если первая кнопка не пустая, далее
        if(button1.getText().equals(button2.getText()) && button2.getText().equals(button3.getText())) // проверка 1 строки
            return true;
        if(button1.getText().equals(button4.getText()) && button4.getText().equals(button7.getText())) // проверка 1 го столбца
            return true;
        if(button1.getText().equals(button5.getText()) && button5.getText().equals(button9.getText())) // проверка главной диагонали
            return true;
    }

    if(!button5.getText().equals("")){ // если пятая кнопка не пустая, далее
        if(button4.getText().equals(button5.getText()) && button5.getText().equals(button6.getText())) // проверка 2 строки
            return true;
        if(button2.getText().equals(button5.getText()) && button5.getText().equals(button8.getText()))  // проверка 2 го столбца
            return true;
        if(button3.getText().equals(button5.getText()) && button5.getText().equals(button7.getText())) // проверка побочной диагонали
            return true;
    }

    if(!button9.getText().equals("")){ // если девятая кнопка не пустая, далее
        if(button7.getText().equals(button8.getText()) && button8.getText().equals(button9.getText())) // проверка 3 строки
            return true;
        if(button3.getText().equals(button6.getText()) && button6.getText().equals(button9.getText())) // проверка 3 го столбца
            return true;
    }
    return false; // иначе возвращаем false- еще никто не выиграл
}

    //  функция для остановки игры при победе или ничье
    public void stopGame(){
        button1.setDisable(true);
        button2.setDisable(true);
        button3.setDisable(true);
        button4.setDisable(true);
        button5.setDisable(true);
        button6.setDisable(true);
        button7.setDisable(true);
        button8.setDisable(true);
        button9.setDisable(true);

    }

    // функция рестарта игры
    public void restartGame(){
        moves = 0; // обнуляем ходы
        flag = true; // меняем ход на 1-го игрока
        button1.setDisable(false); // активируем все 9 кнопок...
        button2.setDisable(false);
        button3.setDisable(false);
        button4.setDisable(false);
        button5.setDisable(false);
        button6.setDisable(false);
        button7.setDisable(false);
        button8.setDisable(false);
        button9.setDisable(false);
        button1.setText(""); // удаляем текст со всех кнопок
        button2.setText("");
        button3.setText("");
        button4.setText("");
        button5.setText("");
        button6.setText("");
        button7.setText("");
        button8.setText("");
        button9.setText("");
    }



// функция, запускающиеся при открытии игры
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    // ставим "слушателей" для всех кнопок по нажатию вызываем нашу функцию хода move
        button1.setOnAction(event -> move(button1));
        button2.setOnAction(event -> move(button2));
        button3.setOnAction(event -> move(button3));
        button4.setOnAction(event -> move(button4));
        button5.setOnAction(event -> move(button5));
        button6.setOnAction(event -> move(button6));
        button7.setOnAction(event -> move(button7));
        button8.setOnAction(event -> move(button8));
        button9.setOnAction(event -> move(button9));
        // ------------Тут нужно будет раскомментировать слушателя для кнопки рестарта------------------
        button10.setOnAction(event -> restartGame());

    }
}
