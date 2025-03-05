package com.example.botesdedialogue;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.Calendar;
//MainActivity : Classe principale de l'application.
//extends AppCompatActivity : Hérite des fonctionnalités d'une activité.
public class MainActivity extends AppCompatActivity {
//recyclerView : Widget pour afficher une liste d'options.
//adapter : Objet responsable de relier les données au RecyclerView.
    private RecyclerView recyclerView;
    private DialogAdapter adapter;
//onCreate : Méthode appelée lors de la création de l'activité.
//savedInstanceState : Permet de restaurer l'état de l'activité après une interruption.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Appelle la méthode onCreate de la classe parent pour initialiser les éléments de base.
        super.onCreate(savedInstanceState);
        //Associe l'interface définie dans activity_main.xml à cette activité.
        setContentView(R.layout.activity_main);
        //Initialisation des données
        //Récupère une référence au RecyclerView défini dans le fichier XML.
        recyclerView = findViewById(R.id.recyclerViewDialogs);
       // Crée une liste d'options (objets DialogOption
        ArrayList<DialogOption> options = new ArrayList<>();
        //Ajoute une option à la liste avec un titre ("Afficher AlertDialog") et une icône.
        options.add(new DialogOption("Afficher AlertDialog", R.drawable.ic_alert));
        options.add(new DialogOption("Afficher ProgressDialog", R.drawable.ic_progress));
        options.add(new DialogOption("Afficher DatePickerDialog", R.drawable.ic_date));
        options.add(new DialogOption("Afficher TimePickerDialog", R.drawable.ic_time));
        options.add(new DialogOption("Afficher CustomDialog", R.drawable.ic_custom));
        options.add(new DialogOption("Afficher BottomSheetDialog", R.drawable.ic_bottom_sheet));
      //Configuration du RecyclerView
        //Crée une instance de DialogAdapter avec les options et un gestionnaire de clics.
        adapter = new DialogAdapter(options, this::handleOptionClick);
        //Définit une disposition verticale pour le RecyclerView.
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //Associe l'adaptateur au RecyclerView.
        recyclerView.setAdapter(adapter);
    }
//Méthode handleOptionClick
    //Gère les clics sur les options. Reçoit le nom de l'option cliquée.
    private void handleOptionClick(String optionName) {
        switch (optionName) {
            case "Afficher AlertDialog":
                showAlertDialog();
                break;
            case "Afficher ProgressDialog":
                showProgressDialog();
                break;
            case "Afficher DatePickerDialog":
                showDatePickerDialog();
                break;
            case "Afficher TimePickerDialog":
                showTimePickerDialog();
                break;
            case "Afficher CustomDialog":
                showCustomDialog();
                break;
            case "Afficher BottomSheetDialog":
                showBottomSheetDialog();
                break;
        }
    }
//Affichage des dialogues
    //Affiche une boîte de dialogue avec deux boutons.
    private void showAlertDialog() {
        new androidx.appcompat.app.AlertDialog.Builder(this)
                .setTitle("AlertDialog")
                .setMessage("Ceci est une boîte de dialogue AlertDialog.")
                .setPositiveButton("OK", (dialog, which) -> {
                    // Action pour le bouton OK
                    Toast.makeText(this, "OK sélectionné", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .setNegativeButton("Annuler", (dialog, which) -> {
                    // Action pour le bouton Annuler
                    Toast.makeText(this, "Annuler sélectionné", Toast.LENGTH_SHORT).show();
                    dialog.dismiss();
                })
                .show();
    }
//Affiche une boîte de dialogue indiquant un chargement.
    private void showProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Chargement...");
        progressDialog.show();
    }
//Affiche un sélecteur de date. Utilise Calendar pour initialiser avec la date actuelle.
    private void showDatePickerDialog() {
        Calendar calendar = Calendar.getInstance();
        new DatePickerDialog(this, (view, year, month, day) ->
                Toast.makeText(this, "Date sélectionnée : " + day + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show(),
                calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
                .show();
    }
//Affiche un sélecteur d'heure avec des valeurs par défaut (12:00).
    private void showTimePickerDialog() {
        new TimePickerDialog(this, (view, hourOfDay, minute) ->
                Toast.makeText(this, "Heure sélectionnée : " + hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show(),
                12, 0, true)
                .show();
    }
//Charge un layout personnalisé (dialog_custom.xml) pour afficher une boîte de dialogue.
    private void showCustomDialog() {
        //Explication de LayoutInflater.from(this).inflate(R.layout.dialog_custom, null);
        //1. Décomposer la ligne
        //LayoutInflater.from(this) :
        //
        //Cette méthode récupère un LayoutInflater lié au contexte (this)
        // pour convertir un fichier XML en une instance de vue utilisable.
        //inflate(R.layout.dialog_custom, null) :
        //
        //Charge le fichier XML dialog_custom.xml en mémoire et crée une hiérarchie d'objets View correspondante.
        //2. Pourquoi this ?
        //this fait référence au contexte actuel, dans ce cas, l'instance de l'activité (MainActivity).
        //Android utilise le contexte pour accéder aux ressources,
        // afficher des vues ou interagir avec le système. Ici, le contexte est nécessaire
        // pour que LayoutInflater sache où chercher le fichier XML.
        //3. Pourquoi null dans inflate ?
        //Le deuxième paramètre de inflate est le parent ViewGroup dans lequel la vue doit être ajoutée.
        //Dans ce cas :
        //Vous utilisez cette vue pour une boîte de dialogue.
        //La boîte de dialogue n'a pas encore de parent ViewGroup, donc on passe null.
        //Que fait Android quand on passe null ?
        //Android crée la hiérarchie de la vue sans essayer de l'attacher immédiatement à un parent.
        //4. Que retourne cette ligne ?
        //LayoutInflater.from(this).inflate(R.layout.dialog_custom, null)
        // retourne un objet de type View, qui correspond à la hiérarchie des vues définies dans dialog_custom.xml.
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null);
        new androidx.appcompat.app.AlertDialog.Builder(this)
                //Ajoute un titre à la boîte de dialogue.
                .setTitle("Custom Dialog")
                //Associe la vue personnalisée (dialog_custom.xml) à la boîte de dialogue.
                .setView(view)
                //dialog : Représente l'instance actuelle de la boîte de dialogue.
                //which : Indique le bouton qui a été cliqué (par exemple,
                // DialogInterface.BUTTON_POSITIVE pour le bouton positif).
                //Action : dialog.dismiss()
                //
                //dialog.dismiss() : Ferme la boîte de dialogue actuelle.
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                //Affiche la boîte de dialogue.
                .show();
    }
    // View view = LayoutInflater.from(this).inflate(R.layout.dialog_custom, null);
    //Charge le fichier dialog_custom.xml qui définit un design personnalisé pour la boîte de dialogue.
    //Ce layout contient probablement un TextView pour le titre ou les instructions et un EditText
// pour permettre à l'utilisateur de saisir des données.


//Comment expliquer cela aux étudiants :
//Montrez-leur le fichier dialog_custom.xml, qui peut inclure
// des éléments comme un champ texte (par exemple, pour entrer un nom).
//Expliquez que la méthode inflate convertit ce fichier XML en une vue utilisable dans l'application.
//Soulignez que cette boîte de dialogue est flexible : vous pouvez y ajouter
// des champs ou des boutons supplémentaires selon vos besoins.
//Exemple d'utilisation : Saisir des informations utilisateur, comme un nom ou une adresse e-mail.



//Affiche une boîte de dialogue glissante depuis le bas de l'écran.
    private void showBottomSheetDialog() {
        BottomSheetDialog dialog = new BottomSheetDialog(this);
        View view = LayoutInflater.from(this).inflate(R.layout.bottom_sheet_layout, null);
        dialog.setContentView(view);
        dialog.show();
    }
}
//Comment expliquer cela aux étudiants :
//Montrez-leur le fichier bottom_sheet_layout.xml,
// qui peut contenir un TextView pour afficher un message et un Button pour permettre à l'utilisateur de fermer la boîte.
//Soulignez la différence visuelle par rapport à un AlertDialog :
// le BottomSheetDialog est glissant, ce qui est souvent utilisé pour des actions ou des options supplémentaires.
//Exemple d'utilisation : Afficher un menu avec des options supplémentaires ou des actions rapides.
