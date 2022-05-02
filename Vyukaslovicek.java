package com.example.konecnejavafx;

import java.net.SocketOption;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class Vyukaslovicek extends Application {
//Arraylist pro česká slovíčka
    private final ArrayList<String> cestina = new ArrayList<>();
//Arraylist pro německá slovíčka
    private final ArrayList<String> nemcina = new ArrayList<>();
//Arraylist má sloužit k funkci jako u for loop
    private final ArrayList<Integer> pocetOpakovaniReset = new ArrayList<>();
//Arraylist slouží k počítání bodů
    private final ArrayList<Integer> pocetBodu = new ArrayList<>();
    int pocetOpakovani = 10;
    private int index;


    @Override

    public void start(Stage stage){
//Zde jsou přidány česká slova
        cestina.add("snídaně");
        cestina.add("snídat");
        cestina.add("zelenina");
        cestina.add("plakát");
        cestina.add("inzerát");
        cestina.add("ryba");
        cestina.add("zdravý");
        cestina.add("pozvat");
        cestina.add("vajíčko");
        cestina.add("chleba");
        cestina.add("salám");
        cestina.add("houska");
        cestina.add("kus");
        cestina.add("tvaroh");
        cestina.add("jablko");
        cestina.add("džem");
        cestina.add("sklenice");
        cestina.add("mléko");
        cestina.add("džus");
        cestina.add("pomeranč");
        cestina.add("pomerančový džus");
        cestina.add("šálek");
        cestina.add("kakao");
        cestina.add("láhev");
//Přidána německá slova
        nemcina.add("Frühstück");
        nemcina.add("frühstücken");
        nemcina.add("das Gemüse");
        nemcina.add("das Plakat");
        nemcina.add("die Anzeige");
        nemcina.add("der Fisch");
        nemcina.add("gesund");
        nemcina.add("einladen");
        nemcina.add("das Ei");
        nemcina.add("das Brot");
        nemcina.add("die Wurst");
        nemcina.add("das Brötchen");
        nemcina.add("das Stück ");
        nemcina.add("der Quark");
        nemcina.add("der Apfel");
        nemcina.add("die Marmelade");
        nemcina.add("das Glas");
        nemcina.add("die Milch");
        nemcina.add("der Saft");
        nemcina.add("die Orange");
        nemcina.add("der Orangensaft");
        nemcina.add("die Tasse");
        nemcina.add("der Kakao");
        nemcina.add("die Flashe");
//Zavolání metody Random()
        Random a = new Random();
//Proměnná s náhodnou hodnotou od 1 do 24
        index = a.nextInt(cestina.size());
//Vytvoření všech používaných tlačítek
        Button zkontrolovat = new Button("zkontrolovat");
        Button dalsi = new Button("další");
        Button zacinameButton = new Button("Start");
        Button zkusitz = new Button("zkusit znovu");
//Tento štítek s textem obsahuje náhodný index z Arryalistu pro česká slova
        Label cesky = new Label(cestina.get(index));
//Ostatní štítky s textem
        Label pocetboduLabel = new Label();
        Label kontrola = new Label();
//Textové pole pro naši odpověď
        TextField textField = new TextField();
//Slouží k zobrazení všech určených komponentů v danné scéně
        VBox vBox = new VBox();
        StackPane layout = new StackPane();
        VBox layout1 = new VBox();
//Vytvořené scény
        Scene scene1 = new Scene(layout, 600, 400);
        Scene scene2 = new Scene(vBox, 600, 400);
        Scene scene3 = new Scene(layout1 ,600,400);
//Vytvoření pozadí s zelenou barvou
        BackgroundFill background_fill = new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY);
        Background background = new Background(background_fill);
//Nastavení typu textu a velikosti u určitého štítku s textem
        kontrola.setFont(new Font("Arial", 24));
//přidána funkce, kdy po stisktuní tlačítka "zaciname" se změní scéna na scénu dva
        zacinameButton.setOnAction(e -> stage.setScene(scene2));
//Tlačítko "dalsi" je nezmáčkutelné
        dalsi.setDisable(true);
//Nastavení velikosti tlačítka a textu v něm
        zacinameButton.setMaxSize(150, 90);
        zacinameButton.setStyle("-fx-font-size: 2em; ");
//Nastavení typu textu a velikosti u určitého štítku s textem
        cesky.setFont(new Font("Arial", 24));
        pocetboduLabel.setMaxSize(300,220);
        pocetboduLabel.setFont(Font.font("Verdana", FontWeight.BOLD, 25));
//Nastavení typu textu a velikosti u textového pole
        textField.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        textField.setMaxSize(250,100);
//Zarovnání a odsazení ukázaných konponetů a nastavení pozadí
        vBox.setAlignment(Pos.CENTER);
        vBox.setSpacing(30);
        vBox.getChildren().addAll(cesky, textField, zkontrolovat, kontrola, dalsi);
        vBox.setBackground(background);
        layout.getChildren().add(zacinameButton);
        layout.setBackground(background);
        layout1.getChildren().addAll(pocetboduLabel,zkusitz);
        layout1.setBackground(background);
        layout1.setAlignment(Pos.CENTER);
        layout1.setSpacing(30);
//Nastavení jaké scény bude plátno ukazovat nejdříve
        stage.setScene(scene1);
        stage.setTitle("Výuka slovíček");
        stage.show();

        //Část kódu od řádku 147 po 195 byla z velké části převzata z odpovědi na můj dotaz na https://stackoverflow.com/questions/71887428/how-to-implement-java-methods-in-to-javafx
                zkontrolovat.setOnAction(e -> {
//Neznámá se vstupem z klávesnice
                    String odpoved = textField.getText();
//Pokud se vstup z klávesnice rovná německému překladu českého slova
                    if (odpoved.equals(nemcina.get(index))) {
//Nastavý se danný text a jeho barva
                        kontrola.setText("spravne");
                        kontrola.setTextFill(Color.LIME);
//Do Arraylistu "pocetBodu" a "pocetOpakovaniReset" se přičte element
                        pocetBodu.add(69);
                        pocetOpakovaniReset.add(69);
//Nastavení štítku s textem pro zobrazení počtu bodů
                        pocetboduLabel.setText("počet bodů: " + pocetBodu.size() + " z " + pocetOpakovani);
//Tlačítko "dalsi" bude zmáčknutelné
                        dalsi.setDisable(false);
//Tlačítko "zkontrolovat" bude nezmáčknutelné
                        zkontrolovat.setDisable(true);
//Pokud se vstup z klávesnice nerovná německému překladu
                    } else {
//Do Arraylistu "pocetOpakovaniReset" se přičte element
                        pocetOpakovaniReset.add(69);
//Nastavý se danný text a jeho barva
                        kontrola.setTextFill(Color.RED);
                        kontrola.setText("spatne");
//Do Arraylistu s českými i německými slovy se přičte element zodpovězený špatně a tim se jeho šance, že se objeví, zvýší
                        cestina.add(cestina.get(index));
                        nemcina.add(nemcina.get(index));
                        pocetboduLabel.setText("počet bodů: " + pocetBodu.size() + " z " + pocetOpakovani);
//Tlačítko "dalsi" bude zmáčknutelné
                        dalsi.setDisable(false);
//Tlačítko "zkontrolovat" bude nezmáčknutelné
                        zkontrolovat.setDisable(true);

                    }

                });

                dalsi.setOnAction(e -> {
                    index = a.nextInt(cestina.size());
//Po zmáčknutí nastaví se náhodný element do štítku s textem
                    cesky.setText(cestina.get(index));
//Pokud je pocet elementů v "pocetOpakovaniReset" roven "pocetOpakovani", po stisknutí tlačítka "dalsi" scéna se přepne na scénu 3
                        if(pocetOpakovaniReset.size() == pocetOpakovani){
                           stage.setScene(scene3);

                        }else{
//Pokud ne, text z textového pole a štítku se vymaže
                            cesky.setText(cestina.get(index));
                            kontrola.setText("");
                            textField.setText("");
//Tlačítko "zkontrolovat" bude zmáčknutelné
                            zkontrolovat.setDisable(false);
//Tlačítko "dalsi" bude nezmáčknutelné
                            dalsi.setDisable(true);

                        }

                });
                zkusitz.setOnAction(c ->{
//Po zmáčknutí se scéna změní spátky na scénu 2
                    stage.setScene(scene2);
//Vymaže všechny elementy z listu pro česká i německá slovíčka a přidá původní počet elemntů
                    cestina.clear();

                    cestina.add("snídaně");
                    cestina.add("snídat");
                    cestina.add("zelenina");
                    cestina.add("plakát");
                    cestina.add("inzerát");
                    cestina.add("ryba");
                    cestina.add("zdravý");
                    cestina.add("pozvat");
                    cestina.add("vajíčko");
                    cestina.add("chleba");
                    cestina.add("salám");
                    cestina.add("houska");
                    cestina.add("kus");
                    cestina.add("tvaroh");
                    cestina.add("jablko");
                    cestina.add("džem");
                    cestina.add("sklenice");
                    cestina.add("mléko");
                    cestina.add("džus");
                    cestina.add("pomeranč");
                    cestina.add("pomerančový džus");
                    cestina.add("šálek");
                    cestina.add("kakao");
                    cestina.add("láhev");

                    nemcina.clear();

                    nemcina.add("Frühstück");
                    nemcina.add("frühstücken");
                    nemcina.add("das Gemüse");
                    nemcina.add("das Plakat");
                    nemcina.add("die Anzeige");
                    nemcina.add("der Fisch");
                    nemcina.add("gesund");
                    nemcina.add("einladen");
                    nemcina.add("das Ei");
                    nemcina.add("das Brot");
                    nemcina.add("die Wurst");
                    nemcina.add("das Brötchen");
                    nemcina.add("das Stück ");
                    nemcina.add("der Quark");
                    nemcina.add("der Apfel");
                    nemcina.add("die Marmelade");
                    nemcina.add("das Glas");
                    nemcina.add("die Milch");
                    nemcina.add("der Saft");
                    nemcina.add("die Orange");
                    nemcina.add("der Orangensaft");
                    nemcina.add("die Tasse");
                    nemcina.add("der Kakao");
                    nemcina.add("die Flashe");
//Text z textového pole a štítku se vymaže
                    textField.setText("");
                    kontrola.setText("");
//tlačítko "zkontrolovat" bude zmáčknutelné a "dalsi" nezmáčknutelné
                    zkontrolovat.setDisable(false);
                    dalsi.setDisable(true);
//Všechny elementy se z Arraylistů vymažou
                    pocetOpakovaniReset.clear();
                    pocetBodu.clear();
                });

            }
    public static void main(String[] args) {
        launch();
    }

}
