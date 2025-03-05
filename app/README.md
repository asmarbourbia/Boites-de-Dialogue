# Boîtes de Dialogue Android

## Description
Ce projet Android met en œuvre différentes boîtes de dialogue (`Dialog`) pour améliorer l'interaction utilisateur. Il comprend plusieurs types de boîtes de dialogue telles que `AlertDialog`, `ProgressDialog`, `DatePickerDialog`, `TimePickerDialog`, `CustomDialog` et `BottomSheetDialog`.
## Aperçu

Voici un aperçu de l'interface :

![Aperçu de l'application](screenshot.png)
## Fonctionnalités
- **AlertDialog** : Boîte de dialogue standard avec message et boutons d'action.
- **ProgressDialog** : Indicateur de chargement.
- **DatePickerDialog** : Sélecteur de date.
- **TimePickerDialog** : Sélecteur d'heure.
- **CustomDialog** : Boîte de dialogue personnalisée avec une mise en page XML.
- **BottomSheetDialog** : Boîte de dialogue glissante depuis le bas de l'écran.

## Technologies utilisées
- **Langage** : Java
- **Framework** : Android SDK
- **Bibliothèques** :
    - `androidx.appcompat.app.AlertDialog`
    - `android.app.DatePickerDialog`
    - `android.app.ProgressDialog`
    - `android.app.TimePickerDialog`
    - `com.google.android.material.bottomsheet.BottomSheetDialog`

## Installation
1. **Cloner le dépôt** :
   ```sh
   git clone <URL_DU_REPO>
   cd <NOM_DU_REPO>
   ```
2. **Ouvrir avec Android Studio** :
    - Lancer Android Studio
    - Ouvrir le projet
    - Synchroniser avec Gradle
3. **Exécuter l'application** :
    - Sélectionner un émulateur ou un appareil physique
    - Cliquer sur `Run` ▶

## Structure du code
- **`MainActivity.java`** : Gère l'affichage des boîtes de dialogue.
    - `handleOptionClick(String optionName)`: Gère les événements de clics.
    - `showAlertDialog()`: Affiche un `AlertDialog`.
    - `showProgressDialog()`: Affiche un `ProgressDialog`.
    - `showDatePickerDialog()`: Affiche un `DatePickerDialog`.
    - `showTimePickerDialog()`: Affiche un `TimePickerDialog`.
    - `showCustomDialog()`: Affiche un `CustomDialog` basé sur `dialog_custom.xml`.
    - `showBottomSheetDialog()`: Affiche un `BottomSheetDialog`.
- **`DialogAdapter.java`** : Gère la liste des options avec `RecyclerView`.
- **Layouts XML** :
    - `activity_main.xml` : Interface principale avec `RecyclerView`.
    - `dialog_custom.xml` : Mise en page du `CustomDialog`.
    - `bottom_sheet_layout.xml` : Mise en page du `BottomSheetDialog`.

## Licence
Ce projet est sous licence **Apache License 2.0** - voir le fichier [LICENSE](LICENSE) pour plus de détails.

