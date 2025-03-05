package com.example.botesdedialogue;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
// la classe DialogAdapter, utilisée dans l'application pour gérer l'affichage des options dans un RecyclerView
//Hérite de RecyclerView.Adapter pour créer un adaptateur spécifique à DialogAdapter.
//Spécifie un ViewHolder personnalisé pour optimiser la gestion des vues.
public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.ViewHolder> {
//dialogOptions : Liste des options à afficher dans le RecyclerView.
//listener : Interface pour gérer les clics sur les options.
    private final ArrayList<DialogOption> dialogOptions;
    private final OnOptionClickListener listener;
//Constructeur
    //ArrayList<DialogOption> dialogOptions : Liste des options passées à l'adaptateur.
//OnOptionClickListener listener : Gestionnaire de clics. Défini dans MainActivity.
    public DialogAdapter(ArrayList<DialogOption> dialogOptions, OnOptionClickListener listener) {

        this.dialogOptions = dialogOptions;
        this.listener = listener;
    }

    @NonNull
    @Override
    //Méthodes Override
    //Rôle : Crée une nouvelle vue pour chaque item dans la liste.
    //Étapes :
    //LayoutInflater.from(parent.getContext()) : Récupère un objet pour charger un fichier XML en vue.
    //inflate(R.layout.item_dialog_option, parent, false) : Charge le fichier item_dialog_option.xml comme vue.
    //Retourne une nouvelle instance de ViewHolder contenant cette vue.
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_dialog_option, parent, false);
        return new ViewHolder(view);
    }

    @Override
    //Rôle : Remplit la vue avec les données pour une position donnée dans la liste.
    //Étapes :
    //dialogOptions.get(position) : Récupère l'option correspondant à la position.
    //holder.tvOptionName.setText(option.getName()) : Définit le texte de l'option.
    //holder.ivIcon.setImageResource(option.getIcon()) : Définit l'icône de l'option.
    //holder.itemView.setOnClickListener(...) : Définit une action lors du clic sur l'item.
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        DialogOption option = dialogOptions.get(position);
        holder.tvOptionName.setText(option.getName());
        holder.ivIcon.setImageResource(option.getIcon());
        holder.itemView.setOnClickListener(v -> listener.onOptionClick(option.getName()));
    }

    @Override
    //Retourne le nombre total d'éléments dans la liste (utilisé par le RecyclerView).
    public int getItemCount() {
        return dialogOptions.size();
    }
//Classe interne ViewHolder
    //Rôle : Représente la vue d’un item dans le RecyclerView.
    public static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivIcon;
        TextView tvOptionName;
        //Constructeur
    //itemView.findViewById :
        //ivIcon : L'icône définie dans item_dialog_option.xml.
        //tvOptionName : Le texte définissant le nom de l'option.
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivIcon = itemView.findViewById(R.id.ivIcon);
            tvOptionName = itemView.findViewById(R.id.tvOptionName);
        }
    }
//Interface OnOptionClickListener
    //Rôle : Définit un contrat pour gérer les clics sur les items.
//Méthode onOptionClick :
//Reçoit le nom de l'option cliquée (optionName).
    public interface OnOptionClickListener {
        void onOptionClick(String optionName);
    }
}
//Résumé du Processus
//Création d’un Adapter :
//
//DialogAdapter est initialisé avec une liste de DialogOption et un gestionnaire de clics.
//RecyclerView :
//
//Utilise l'adaptateur pour afficher une liste d'options.
//Actions Utilisateur :
//
//Lorsqu’un utilisateur clique sur un item :
//Le clic est transmis via listener.onOptionClick(option.getName()).
//MainActivity gère l'action correspondante.