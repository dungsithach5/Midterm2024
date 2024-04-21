package com.example.huynhanhtien;

import android.content.Intent;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.huynhanhtien.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private MyDatabaseHelper dbHelper;
    private AppDatabase appDatabase;
    private QuestionDAO questionDAO;
    private ArrayList<Question> arrayList;

    private ArrayAdapter<Question> arrayAdapter;

    private ActivityMainBinding binding;
    private int currentIndex = 0;

    private boolean selectedAnswer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        EdgeToEdge.enable(this);
//        setContentView(R.layout.activity_main);
//        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
//            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
//            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
//            return insets;
//        });
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View viewRoot = binding.getRoot();
        setContentView(viewRoot);


        // Khởi tạo MyDatabaseHelper
        dbHelper = new MyDatabaseHelper(this);

        // Lấy giá trị Boolean từ Button
        boolean isTrue = binding.btnTrue.isPressed();

        // Ghi giá trị Boolean vào SQLite
        dbHelper.insertAnswer(isTrue);

        Toolbar toolbar = findViewById(R.id.myToolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("GeoQuiz");

        arrayList = new ArrayList<Question>();
        arrayList.add(new Question("What was the significance of the Battle of Hastings in 1066?",true));
        arrayList.add(new Question("Who was the longest-reigning monarch in British history?",false));
        arrayList.add(new Question("What were the causes and consequences of the French Revolution?",true));
        arrayList.add(new Question("Who were the main leaders of the American Civil Rights Movement in the 1960s?",false));
        arrayList.add(new Question("What was the purpose of the Berlin Conference in 1884-1885?",false));
        arrayList.add(new Question("Who were the key figures involved in the signing of the Magna Carta in 1215?",false));
        arrayList.add(new Question("What were the main events of the Cold War?",true));
        arrayList.add(new Question("What was the impact of the Black Death on medieval Europe?",true));
        arrayList.add(new Question("How did the Industrial Revolution change societies and economies worldwide?",false));
        arrayList.add(new Question("What were the main causes and outcomes of World War I?",true));


        showRandomContent();


        binding.btnTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnTrue.setBackgroundColor(Color.GREEN);
                binding.btnFalse.setBackgroundColor(Color.GRAY);
            }
        });

        binding.btnFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                binding.btnFalse.setBackgroundColor(Color.RED);
                binding.btnTrue.setBackgroundColor(Color.GRAY);
            }
        });


        binding.btnNext.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (currentIndex < arrayList.size() - 1) {
                    currentIndex++;
                    updateQuestion();
                }
            }
        });

        binding.btnPre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex > 0) {
                    currentIndex--;
                    updateQuestion();
                }
            }
        });

        binding.btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void updateQuestion() {
        Question currentQuestion = arrayList.get(currentIndex);
        TextView questionTextView = binding.tvQuestion;
        questionTextView.setText(currentQuestion.getQuestionText());
    }



    private void showRandomContent() {
        Random random = new Random();
        int randomIndex = random.nextInt(arrayList.size());
        Question randomQuestion = arrayList.get(randomIndex);
        binding.tvQuestion.setText(randomQuestion.getQuestionText());
    }



}