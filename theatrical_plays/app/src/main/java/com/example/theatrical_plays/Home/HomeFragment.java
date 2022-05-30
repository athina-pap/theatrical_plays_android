package com.example.theatrical_plays.Home;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.theatrical_plays.Actor.Activity_bio;
import com.example.theatrical_plays.MainActivity;
import com.example.theatrical_plays.ProductionInfo;
import com.example.theatrical_plays.R;
import com.example.theatrical_plays.Venues.TheatersInfo;
import com.squareup.picasso.Picasso;
public class HomeFragment extends Fragment {

    ImageView image1;
    ImageView image2;
    ImageView image3;
    TextView actorn;
    TextView actor2;
    TextView actor3;
    Button moreactors;

    public static HomeFragment newInstance()
    {
        HomeFragment fragmentHome = new HomeFragment();
        return fragmentHome;
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        image1 = rootView.findViewById(R.id.image1);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/nv5TR9NiELEGPJUQqVLEqZzcGZb.jpg").into(image1);
        image2 = rootView.findViewById(R.id.image2);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/mR3QlGx3y68uVZriNzoOLOnwPy.jpg").into(image2);
        image3 = rootView.findViewById(R.id.image3);
        Picasso.get().load("https://image.tmdb.org/t/p/w300/oiectxNJB7ctBwRKY45ChonEbjw.jpg").into(image3);
        moreactors = rootView.findViewById(R.id.moreActors);
        actorn = rootView.findViewById(R.id.actorN);
        actor2 = rootView.findViewById(R.id.actor2);
        actor3 = rootView.findViewById(R.id.actor3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), Activity_bio.class);
                int_detail.putExtra("id",6911);
                int_detail.putExtra("fullName", actorn.getText());
                getActivity().startActivity(int_detail);
            }
        });


        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), Activity_bio.class);
                int_detail.putExtra("id",5044);
                int_detail.putExtra("fullName", actor2.getText());
                getActivity().startActivity(int_detail);
            }
        });


        image3.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Intent int_detail = new Intent(getContext(), Activity_bio.class);
                                          int_detail.putExtra("id", 7544);
                                          int_detail.putExtra("fullName", actor3.getText());
                                          getActivity().startActivity(int_detail);
                                      }
                                  });


       moreactors.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent int_detail = new Intent(getContext(), MainActivity.class);
               int_detail.putExtra("prod", 1);
               getActivity().startActivity(int_detail);
           }
       });

        ImageView prod1 = rootView.findViewById(R.id.imageprod1);
        ImageView prod2 = rootView.findViewById(R.id.imageprod2);
        ImageView prod3 = rootView.findViewById(R.id.imageprod3);

        prod1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "Το θεατρικό μιούζικαλ, με ρεκόρ εισιτήριων, των Θανάση Παπαθανασίου και Μιχάλη Ρέππα σε μια παράσταση πρωταγωνιστών, που σκηνοθετούν ο Θανάσης Παπαθανασίου, ο Μιχάλης Ρέππας και ο Φωκάς Ευαγγελινός.\\n \\nΣΑΒΒΑΤΟ 30/1 ΚΑΙ ΚΥΡΙΑΚΗ 31/1/2021 & extra παράσταση λόγω μεγάλης ζήτησης ΔΕΥΤΕΡΑ 1/2\\nΗ παράσταση της χρόνιας, με πάνω από 8Ο παραστάσεις και 150.000 θεατές!!!\\n17 υπέροχοι ηθοποιοί, 37 τραγούδια με 12μελή ζωντανή ορχήστρα, 24μελές μπαλέτο & 1.000 κοστούμια επί σκηνής και 300 περούκες!\\n \\nΈπειτα από την τεράστια αγκαλιά, χιλιάδων θεατών όλων των ηλικιών, το καλοκαίρι του 2019, η υπέρ-παραγωγή, “Το δικό μας σινεμά”, το θεατρικό μιούζικαλ με την υπογραφή του συγγραφικού δίδυμου των μεγάλων επιτυχιών Θανάση Παπαθανασίου και Μιχάλη Ρέππα και τις ευφάνταστες χορογραφίες του Φωκά Ευαγγελινού, έρχεται, για πρώτη φορά, μέσω online streaming*, από το ιστορικό Θέατρο Άλσος, στις οθόνες σας!\\nΗ πολυσυζητημένη παράσταση, που άφησε εποχή, ζωντανεύει - διαδικτυακά αυτή τη φορά - για να ζήσετε, από την άνεση του σπιτιού σας, την μαγεία του παλιού Ελληνικού κινηματογράφου, μέσα από τα studio της Φίνος Φιλμ!\\nΟ Σπύρος Παπαδόπουλος, η Δέσποινα Βανδή, ο Παύλος Χαϊκάλης, ο Κώστας Κόκλας, η Κατερίνα Λέχου, ο Μέμος Μπεγνής, ο Γιώργος Χρανιώτης, η Σύλβια Δελικούρα, η Παρθένα Χοροζίδου, η Ευγενία Σαμαρά, η Μαριλού Κατσαφάδου, η Μαριαλένα Ροζάκη, ο Γιώργος Τσούρμας, ο Γιάννης Ρούσος, ο Δημήτρης Γαλάνης και σε ξεχωριστούς ρόλους η Πηνελόπη Πιτσούλη, η Ελένη Γερασιμίδου και ο Γιώργος Κωνσταντίνου είναι έτοιμοι να δώσουν άλλη διάσταση στα βράδια σας, στις 30 & 31/1/2021, από την μεγάλη σκηνή του πιο εμβληματικού θερινού θεάτρου της Αθήνας.\\nΕξαιρετικές ερμηνείες, υπέροχα τραγούδια, χορός και 1.000 κοστούμια, μέσα σε ένα ευφάνταστο σκηνικό, με υψηλής ποιότητας υπηρεσίες στον ήχο και φώτα τελευταίας τεχνολογίας, δίνουν το στίγμα της παράστασης.\\n“Το δικό μας σινεμά”, είναι η ιστορία κάποιων καλλιτεχνών που ξεκινάνε περίπου το 1955 όταν πια αρχίζει η μεγάλη άνοδος του κινηματογράφου, ζουν την μεγάλη δόξα της δεκαετίας του '60 και ακολουθούν την πτώση του σινεμά στη δεκαετία του '70.\\nΜε νοσταλγία, χιούμορ, τρυφερότητα αλλά και συγκίνηση μας θυμίζουν μια εποχή που έχουμε αγαπήσει και συνεχίζουμε να αγαπάμε. “Το δικό μας σινεμά” είναι ένα ταξίδι στη χρυσή εποχή του παλιού καλού ελληνικού κινηματογράφου.\\n“Το δικό μας σινεμά”, με χαρακτήρες και τραγούδια αγαπημένα, μεγάλες επιτυχίες που έχουν γραφτεί στην ψυχή και τη μνήμη μας, περιδιαβαίνει τα χρόνια της μεγάλης ανόδου, της ακμής και της παρακμής του ελληνικού κινηματογράφου μέσα από τις ζωές κάποιων πρωταγωνιστών του κινηματογράφου.\\nΜια παραγωγή του MK GROUP, των Ηλία Μαροσούλη και Άγγελου Κοταρίδη.\\n*H κινηματογράφηση έχει γίνει εν ώρα παράστασης από κάμερες υψηλής ποιότητας σε ανάλυση full hd και με τον φυσικό ήχο της παράστασης, δημιουργώντας μία εμπειρία θέασης at-home για κινητά, tablets,  υπολογιστές και smart TV.\\n \\nINFO:\\nONLINE STREAMING - Θέατρο ΑΛΣΟΣ\\nΗμερομηνία: Σάββατο 30/1 & Κυριακή 31/1/21\\nΔιάρκεια παράστασης: 2μιση ώρες\\nΤιμή εισιτήριου: 15 € \\n \\nΛίγα λόγια για το έργο …\\nO Πέτρος (Σπύρος Παπαδόπουλος) είναι πρωταγωνιστής του θεάτρου και κάνει τις πρώτες του ταινίες στη δεκαετία του ’50. Είναι παντρεμένος με την Μιράντα (Κατερίνα Λέχου) η οποία είναι σταρ του θεάτρου και περιφρονεί το σινεμά αλλά κάνει και κάποιες ταινίες για να βγάζει χρήματα. Η Μιράντα  έχει μια κόρη από τον προηγούμενο γάμο της, την Δανάη (Ευγενία Σαμαρά).\\nΗ Μαίρη (Δέσποινα Βανδή) είναι μια πετυχημένη τραγουδίστρια που στην δεκαετία του '50 κάνει ρόλους σε ταινίες του άντρα της, Γιώργου (Κώστας Κόκλας) που είναι σεναριογράφος και σκηνοθέτης.\\nΌταν ο Πέτρος και η Μαίρη συνεργάζονται για πρώτη φορά σε μια ταινία του Γιώργου αρχίζει μια ιστορία με έρωτες, ανταγωνισμούς, φιλοδοξίες και διαψεύσεις.\\nΗ ιστορία αυτή κρατάει μέχρι το ΄77 την χρονιά που πεθαίνει ο Φιλοποίμενας Φίνος και στην ουσία λήγει η ιστορία του παλιού ελληνικού κινηματογράφου. Γύρω από αυτά τα τέσσερα πρόσωπα περιστρέφεται ένας ολόκληρος κόσμος από καλλιτέχνες που ζουν και εργάζονται στα στούντιο της Φίνος Φιλμ.\\nΟ Χρόνης (Παύλος Χαικάλης) είναι ο χορογράφος των επιτυχιών της εποχής.\\nΗ Ζωγραφούλα (Ελένη Γερασιμίδου) είναι η μητέρα του Πέτρου.\\nΟ Κώστας (Γιώργος Κωνσταντίνου) και η Δέσπω (Πηνελόπη Πιτσούλη) είναι ζευγάρι παλιών ηθοποιών απο τα μπουλούκια που έχουν δύο κόρες την Μαίρη και την Ντίνα (Παρθένα Χοροζίδου), μια μοδίστρα στα στούντιο του Φίνου.\\nΟ Στέφανος (Μέμος Μπεγνής) είναι ανερχόμενος ζεν πρεμιέ εκείνης της εποχής, όπως και ο Παύλος (Γιώργος Χρανιώτης) ο οποίος είναι παντρεμένος με μια στάρλετ την Φανή (Σύλβια Δελικούρα).\\nΚαι μην αναζητήσετε οποιαδήποτε ομοιότητα με πραγματικά πρόσωπα ή γεγονότα. Γιατί το χαρισματικό δίδυμο επινοεί προς τέρψιν των θεατών ιστορίες που εμπνέονται από την πραγματική ζωή του χτες και του σήμερα και τις μπολιάζει με μοναδικά τραγούδια, μεγάλες επιτυχίες της εποχής σε νέες ενορχηστρώσεις που ερμηνεύονται από τους ηθοποιούς και την με 12μελή ζωντανή ορχήστρα. Συμμετέχει 24μελές μπαλέτο.\\n \\nΕυχαριστούμε πολύ!");
                int_detail.putExtra("id",509);
                int_detail.putExtra("title", "Το δικό μας Σινεμά");
                int_detail.putExtra("producer", "ΑΛΣΟΣ ΠΕΔΙΟΝ ΤΟΥ ΑΡΕΩΣ Ι.Κ.Ε");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/d8b548e8-490c-488f-9939-afd8ed7e821c/%ce%a4%ce%9f-%ce%94%ce%99%ce%9a%ce%9f-%ce%9c%ce%91%ce%a3-%ce%a3%ce%99%ce%9d%ce%95%ce%9c%ce%91---Online-Streaminfc370b491-a9e4.png");
                getActivity().startActivity(int_detail);
            }
        });


        prod2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "Η ΚΑΡΜΕΝ ΡΟΥΓΓΕΡΗ ΕΡΧΕΤΑΙ ΣΤΟ CHRISTMAS THEATER!\\nΟΙ ΑΘΛΟΙ ΤΟΥ ΗΡΑΚΛΗ\\n40.000 θεατές αποθέωσαν την Κάρμεν Ρουγγέρη στις πρώτες παραστάσεις! Η επιτυχία συνεχίζεται στο Christmas Theater! Δείτε το στις νέες παραστάσεις μέχρι τον Απρίλιο!\\nΠΛΗΡΟΦΟΡΙΕΣ 211 7701700 www.ct.gr\\nCHRISTMAS THEATER \\nΜΕΤΑ ΤΗΝ ΜΕΓΑΛΗ ΕΠΙΤΥΧΙΑ ΝΕΕΣ ΠΑΡΑΣΤΑΣΕΙΣ ΜΕΧΡΙ ΤΙΣ 30 ΑΠΡΙΛΙΟΥ!!\\nΜια μεγάλη εντυπωσιακή παράσταση ετοιμάζεται φέτος στο μεγαλύτερο θέατρο της Αθήνας. Η αγαπημένη μικρών και μεγάλων Κάρμεν Ρουγγέρη, η Χριστίνα Κουλουμπή και οι συνεργάτες τους έρχονται στο Christmas Theater για να μας παρουσιάσουν την παράσταση ΟΙ ΑΘΛΟΙ ΤΟΥ ΗΡΑΚΛΗ. Η Κάρμεν Ρουγγέρη και η Χριστίνα Κουλουμπή με μια νέα σκηνοθετική ματιά αλλά και με εντυπωσιακά σκηνικά, κοστούμια και ειδικά εφέ και βιντεοπροβολές, αξιοποιούν τις μεγάλες τεχνολογικές δυνατότητες του Christmas Theater και παρουσιάζουν την ζωή και τους άθλους του Ηρακλή σε μια σπουδαία παράσταση για όλη την οικογένεια. \\nΜια παράσταση για την δύναμη της θέλησης, γιατί όπως έλεγαν και οι αρχαίοι Έλληνες: Δεν υπάρχει τίποτε αδύνατο γι’ αυτόν που θα προσπαθήσει.\\nΠαραμυθένια είναι η αντιμετώπισή μας αλλά συγχρόνως ακριβής. Βασισμένη πάνω σε ότι έχει γραφτεί για τον ήρωα και τη ζωή του έτσι ώστε τα παιδιά να σχηματίσουν μια σαφή εικόνα του Ηρακλή, του ήρωα των ηρώων, που με τους άθλους του έμεινε στην ιστορία ως ο πιο ονομαστός και αγαπητός ήρωας της ανθρωπότητας. Μέσα απ’ αυτή την παράσταση τα παιδιά θα έχουν την ευκαιρία να παρακολουθήσουν:\\n- τη γέννηση του ήρωα\\n- τη ζωή του\\n- τους άθλους του\\n- την καθιέρωση των Ολυμπιακών αγώνων\\n- το θάνατό του\\n- και τέλος τη μετάβασή του στον Όλυμπο όπου θα απολαμβάνει όλες τις τιμές και θα ζήσει ανάμεσα στους δώδεκα θεούς ίσος με αυτούς.\\nΤα μοναδικά σκηνικά και κοστούμια υπογράφει η Χριστίνα Κουλουμπή. Το κείμενο και τη σκηνοθεσία υπογράφει η Κάρμεν Ρουγγέρη, με το μοναδικό της ταλέντο να εμπνέει στα παιδιά κάθε ηλικίας την αγάπη για το θέατρο. Είναι μια αφορμή να ξαναθυμηθούμε τους ήρωες μας σε μια εποχή που τους έχουμε τόση πολλή ανάγκη!\\nΚείμενο – Σκηνοθεσία: Κάρμεν Ρουγγέρη\\nΣκηνικά – Κοστούμια:     Χριστίνα Κουλουμπή\\nΧορογραφίες – Κίνηση – Φωτισμοί: Πέτρος Γάλλιας\\nΜουσική – Video Art : Αντώνης Δελαπόρτας\\nΣτίχοι Τραγουδιών: Ανδρέας Κουλουμπής\\nΔιδασκαλία – Προσαρμογή τραγουδιών: Αγάπη Διαγγελάκη\\nΣπαθογραφίες:  Κωνσταντίνος Μπουμπούκης \\nΒοηθός Σκηνοθέτη – Γραμματειακή υποστήριξη: Ελένη Καρτάση\\n \\n \\nΗθοποιοί:\\nΓιώργος Παράσχος\\nΓιώργος Μπανταδάκης\\nΣτέλιος Νίνης\\nΆρης Δελαγραμμάτικας\\nΝτίνος Γκελαμέρης\\nΝίκος Καλιδώνης\\nΠέτρος Τσαπαλιάρης\\nΧρήστος Μπαλτάς\\nΆντεια Ολυμπίου\\nΈλενα Μιχαλάκη\\nΚωνσταντίνα Κουτσαυτάκη\\nΙουστίνα Μάτσιασεκ\\n \\nΟΙ ΑΘΛΟΙ ΤΟΥ ΗΡΑΚΛΗ της Κάρμεν Ρουγγέρη\\nΑπό το ΣΑΒΒΑΤΟ 9 ΟΚΤΩΒΡΙΟΥ 2021\\nCHRISTMAS THEATER\\nΒΕΪΚΟΥ 137, ΓΑΛΑΤΣΙ\\nΝΕΕΣ ΠΑΡΑΣΤΑΣΕΙΣ:\\nΤΡΙΤΗ 4 ΙΑΝΟΥΑΡΙΟΥ ΣΤΙΣ 15 ΚΑΙ ΣΤΙΣ 19.30\\nΠΕΜΠΤΗ 6 ΙΑΝΟΥΑΡΙΟΥ ΣΤΙΣ 15.00 ΚΑΙ ΣΤΙς 19.30\\nΣΑΒΒΑΤΟ 16 ΑΠΡΙΛΙΟΥ ΣΤΙΣ 15.00 ΚΑΙ ΣΤΙΣ 19.30\\nΚΥΡΙΑΚΗ 17 ΑΠΡΙΛΙΟΥ ΣΤΙΣ 12.00 ΚΑΙ ΣΤΙΣ 17.00\\nΣΑΒΒΑΤΟ 30 ΑΠΡΙΛΙΟΥ ΣΤΙΣ 15.00 ΚΑΙ ΣΤΙΣ 19.30\\n \\nΤΙΜΕΣ ΕΙΣΙΤΗΡΙΩΝ:\\nΠΛΑΤΕΙΑ ΚΑΙ ΚΕΡΚΙΔΑ (ΘΕΑΤΡΙΚΑ ΚΑΘΙΣΜΑΤΑ)\\nVIP: 24 ΕΥΡΩ\\nΑ ΖΩΝΗ: 20 ΕΥΡΩ\\nΒ ΖΩΝΗ: 16 ΕΥΡΩ\\nΚΕΡΚΙΔΑ (ΚΑΘΙΣΜΑΤΑ ΚΕΡΚΙΔΑΣ)\\nΓ ΖΩΝΗ: 13 ΕΥΡΩ\\nΔ ΖΩΝΗ: 10 ΕΥΡΩ\\nΕ ΖΩΝΗ: 5 ΕΥΡΩ\\nΑΜΕΑ: 5 ΕΥΡΩ, ΣΥΝΟΔΟΣ: 10 ΕΥΡΩ (ΜΟΝΟ ΜΕ ΤΗΛΕΦΩΝΙΚΗ ΚΡΑΤΗΣΗ ΣΤΟ 211 7701700 Η ΣΤΟ ΤΑΜΕΙΟ ΤΟΥ CHRISTMAS THEATER)\\nΙΣΧΥΟΥΝ ΕΙΔΙΚΕΣ ΤΙΜΕΣ ΓΙΑ ΟΜΑΔΙΚΑ ΕΙΣΙΤΗΡΙΑ, ΠΛΗΡΟΦΟΡΙΕΣ 211 77 01 700\\n \\n");
                int_detail.putExtra("id",506);
                int_detail.putExtra("title", "Οι Άθλοι του Ηρακλή");
                int_detail.putExtra("producer", "WE PRODUCTION ΠΕΡΑΚΗΣ ΕΥΑΓΓΕΛΟΣ ΚΑΙ ΣΙΑ ΕΕ");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/4e365d06-7ac9-405e-b9d6-7b9b58ef1546/%ce%9f%ce%99-%ce%91%ce%98%ce%9b%ce%9f%ce%99-%ce%a4%ce%9f%ce%a5-%ce%97%ce%a1%ce%91%ce%9a%ce%9b%ce%97-%cf%84%ce%b7%cf%82-%ce%9a%ce%b1%cf%81%ce%bc%ce%b5%ce%bd-%ce%a1%ce%bf%cf%85%ce%b3%ce%b3%ce%b5%cf%81%ce%b7b91bdad8-83.png");
                getActivity().startActivity(int_detail);
            }
        });


        prod3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), ProductionInfo.class);
                int_detail.putExtra("desc", "«Η ΠΟΝΤΙΚΟΠΑΓΙΔΑ»\\nΤης Αγκάθα Κρίστι σε σκηνοθεσία Κίρκης Καραλή\\r\\n \\nΗ HAPPY PRODUCTIONS παρουσιάζει στον Νέο Ακάδημο, σε μια μεγάλη παραγωγή με 8 σημαντικούς πρωταγωνιστές του θεάτρου μας, το θρυλικό έργο μυστηρίου της Αγκάθα Κρίστι «ΠΟΝΤΙΚOΠΑΓΙΔΑ», το μακροβιότερο έργο στην ιστορία του παγκόσμιου θεάτρου (παίζεται συνεχώς στο West End από τo 1952 έως σήμερα), σε μια νέα προσαρμογή \\\"έκπληξη\\\"!\\nH κατεξοχήν συγγραφέας έργων μυστηρίου, όταν το έγραψε, δεν πίστευε ότι θα μπορούσε να αντέξει στη σκηνή για πάνω από 8 εβδομάδες. Όταν η ιστορία τη διέψευσε, απέδωσε την συνεχιζόμενη επιτυχία του έργου στο γεγονός πως υπάρχει «κάτι» στο κείμενο που αφορά κάθε θεατή προσωπικά.\\nΗ αρχική του εκδοχή, το 1947, ήταν ραδιοφωνική, βασισμένη στο αδημοσίευτο, τότε, διήγημα της Αγκάθα Κρίστι με τίτλο \\\"Τρία τυφλά ποντίκια\\\". Τον τίτλο \\\"Ποντικοπαγίδα\\\" τον εμπνεύστηκε από το θεατρικό έργο που στήνει ο Άμλετ στο ομώνυμο έργο του Σαίξπηρ για να συλλάβει την ενοχή της μητέρας και του πατριού του. Στήνει, δηλαδή, ένα θέατρο μέσα στο θέατρο, υιοθετώντας μια αλλοπρόσαλλη συμπεριφορά, προκειμένου να μπερδέψει τους ενόχους και να φέρει στο φως την αλήθεια. Κι αυτή η έμπνευση της Αγκάθα δεν είναι καθόλου τυχαία...\\nΛίγα λόγια για την υπόθεση του έργου:\\nΗ υπόθεση του έργου εκτυλίσσεται σε μια απομονωμένη πανσιόν μιας επαρχίας, την ώρα που το χιόνι πέφτει πυκνό. Οκτώ ήρωες, που όλοι τους κρύβουν ένα μυστικό, βρίσκονται αντιμέτωποι με σκληρές αλήθειες και επικίνδυνα ψέματα.\\nΟ φόβος τους κυκλώνει και ένας δολοφόνος βρίσκεται ανάμεσά τους. Μια ιστορία εκδίκησης με αιφνιδιαστικές ανατροπές, έξυπνα τεχνάσματα και μια ποντικοπαγίδα που περιμένει το επόμενο θύμα της!\\nΣτη νέα προσαρμογή του έργου, σε σκηνοθεσία και δραματουργική επεξεργασία Κίρκης Καραλή, μια ομάδα οκτώ πρωταγωνιστών (Μαρία Κωνσταντάκη, Ερρίκος Λίτσης, Δανάη Λουκάκη, Ράνια Οικονομίδου, Σήφης Πολυζωίδης, Νίκος Πουρσανίδης, Μιχάλης Συριόπουλος, Αποστόλης Τότσικας), μεταφέρεται κάπου στις αρχές της δεκαετίας του '90, προτού μπουν τα κινητά τηλέφωνα στις ζωές μας, σε μια πανσιόν της ελληνικής επαρχίας.\\n….η συνέχεια επί σκηνής στον ΝΕΟ Ακάδημο!\\n….και σσσσσσσσσςςςςς μην ψιθυρίσετε το τέλος σε κανένα!\\nΠαραγωγή: Happy Productions Hellas\\nΝΕΟΣ Ακάδημος: Ακαδημίας & Ιπποκράτους 17, Μετρό Πανεπιστήμιο\\nΤηλέφωνα Επικοινωνίας: 210 3625119 & 210 0080900\\nΠαραστάσεις:\\n\\nΔευτέρα 20:00\\nΤρίτη 21:00\\nΤετάρτη 18:00\\nΣάββατο 21:00\\nΚυριακή 18:00\\n\\nΔιάρκεια Παράστασης: 1 ώρα και 35 λεπτά\\nΤιμές Εισιτηρίων:\\n\\nΔευτέρα-Τετάρτη: Ζώνη Α: 20€ / Ζώνη Β: 18€ / Ζώνη Γ: 15€\\nΤρίτη: Γενική Είσοδος 15€\\nΣάββατο-Κυριακή: Ζώνη Α: 22€ / Ζώνη Β: 20€ / Ζώνη Γ: 15€\\n\\nΆνεργοι, Πολύτεκνοι, ΑΜΕΑ, Συνοδοί ΑΜΕΑ, 65 ετών, Φοιτητές: 15€ (εκτός Σαββάτου/Κυριακής)\\nΕιδικές τιμές για ομαδικές κρατήσεις άνω των 15 ατόμων (στο τηλέφωνο 210 0080900)\\nΟ ΝΕΟΣ Ακάδημος, πλήρως ανακαινισμένος (2019), διαθέτει ολοκαίνουργιο σύστημα εξαερισμού, ψύξης και θέρμανσης με εισροή νωπού αέρα στους χώρους του θεάτρου. Παράλληλα τηρεί αυστηρά όλα τα Πρωτόκολλα Υγειονομικής Προστασίας, με γνώμονα την προστασία κοινού & προσωπικού.\\nΠΡΟΠΩΛΗΣΗ ΕΙΣΙΤΗΡΙΩΝ:\\nα. Ηλεκτρονικά:\\n\\nwww.viva.gr\\nneosakadimos.gr\\n\\nβ. Τηλεφωνικά:\\n\\n210 0080900: Δευτέρα έως Παρασκευή 09:00-19:00 & Σάββατο 09:00-17:00\\n210 3625119: Δευτέρα έως Κυριακή 10:00-21:00\\n\\nγ. Στα ταμεία του ΝΕΟΥ Ακάδημου: Ακαδημίας & Ιπποκράτους 17 (Δευτέρα έως Κυριακή 14:00-22:00)\\nδ. Στα γραφεία της Happy Productions: Μεσογείων 326, Αγία Παρασκευή (Δευτέρα έως Παρασκευή 09:00-19:00 & Σάββατο 09:00-17:00)\\nε. Στο Δίκτυο καταστημάτων VIVA (www.vivapayments.com/el-gr/network)\\nemail: info@happyproductions.gr\\nWeb: www.neosakadimos.gr\\nFacebook 1: www.facebook.com/neosakadimos\\nFacebook 2: www.facebook.com/pontikopagida\\nInstagram 1: www.instagram.com/neosakadimos\\nInstagram 2: www.instagram.com/pontikopagida_2020\\nYou Tube: www.youtube.com/channel/UCt3LXDqOhYhrrxUhu-T01qg\\n#neosakadimos #pontikopagida");
                int_detail.putExtra("id",507);
                int_detail.putExtra("title", "Ποντικοπαγίδα");
                int_detail.putExtra("producer", "Happy Productions IKE");
                int_detail.putExtra("url", "https://www.viva.gr/tickets/getattachment/74515bee-24f3-4145-b283-08311e71b95c/%ce%a0%ce%bf%ce%bd%cf%84%ce%b9%ce%ba%ce%bf%cf%80%ce%b1%ce%b3%ce%b9%ce%b4%ce%b14ca3d290-df96-42f4-81b3-cd17191138e8.png");
                getActivity().startActivity(int_detail);
            }
        });

        Button moreProductions = rootView.findViewById(R.id.moreProductions);
        moreProductions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), MainActivity.class);
                int_detail.putExtra("prod", 2);
                getActivity().startActivity(int_detail);
            }
        });


        ImageView venue1 = rootView.findViewById(R.id.imageVenue1);
        ImageView venue2 = rootView.findViewById(R.id.imageVenue2);
        ImageView venue3 = rootView.findViewById(R.id.imageVenue3);

        venue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 302);
                int_detail.putExtra("title","Νέος Ακάδημος");
                int_detail.putExtra("address", "Athens, Αττική");
                getActivity().startActivity(int_detail);
            }
        });


        venue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 303);
                int_detail.putExtra("title","Θέατρο Μικρο Χορν");
                int_detail.putExtra("address", "Κολωνάκι, Αττική");
                getActivity().startActivity(int_detail);
            }
        });


        venue3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), TheatersInfo.class);
                int_detail.putExtra("id", 305);
                int_detail.putExtra("title","Σύγχρονο Θέατρο");
                int_detail.putExtra("address", "Κεραμεικός, Αττική");
                getActivity().startActivity(int_detail);
            }
        });

        Button moreVenues = rootView.findViewById(R.id.moreVenues);
        moreVenues.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int_detail = new Intent(getContext(), MainActivity.class);
                int_detail.putExtra("prod", 3);
                getActivity().startActivity(int_detail);
            }
        });
        return rootView;
    }
}