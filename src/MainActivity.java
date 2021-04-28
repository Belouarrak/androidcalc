package calculatrice;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.boris.expr.Expr;
import org.boris.expr.ExprEvaluatable;
import org.boris.expr.ExprException;
import org.boris.expr.parser.ExprParser;
import org.boris.expr.util.Exprs;
import org.boris.expr.util.SimpleEvaluationContext;

import java.io.IOException;


public class MainActivity extends Activity implements View.OnClickListener{

    // private static final ParseurMath parseur = ParseurMath.getInstance();

    private Button bt_un;
    private Button bt_deux;
    private Button bt_trois;
    private Button bt_quatre;
    private Button bt_cinq;
    private Button bt_six;
    private Button bt_sept;
    private Button bt_huit;
    private Button bt_neuf;
    private Button bt_zero;
    private Button bt_virgule;
    private Button bt_plus;
    private Button bt_moins;
    private Button bt_fois;
    private Button bt_div;
    private Button bt_egal;
    private Button bt_parentOuv;
    private Button bt_parentFerm;
    private Button bt_abs;
    private Button bt_sqrt;
    private Button bt_puiss;
    private Button bt_sin;
    private Button bt_cos;
    private Button bt_tan;
    private Button bt_asin;
    private Button bt_acos;
    private Button bt_atan;
    private Button bt_ln;
    private Button bt_log;
    private Button bt_exp;

    private Button bt_ac;
    private Button bt_backspace;

    private String mathresult;
    private TextView afficheur;     // Display TextView


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        deserialiserRessources();
        initConnection();

        if (savedInstanceState != null) {
            String archive = savedInstanceState.getString("calcul");
            afficheur.setText(archive);
        }
    }

    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        String archive = afficheur.getText().toString();
        savedInstanceState.putString("calcul", archive);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        String archive = savedInstanceState.getString("calcul");
    }

    private void parser() {
        try {
            SimpleEvaluationContext context = new SimpleEvaluationContext();
            String line = afficheur.getText().toString();
            Expr e = null;
            try {
                e = ExprParser.parse(line);
                Exprs.toUpperCase(e);
                if (e instanceof ExprEvaluatable) {
                    e = ((ExprEvaluatable) e).evaluate(context);

                    Log.i("calc", e.toString());
                }
            } catch (IOException ioException) {
                ioException.printStackTrace();
            } catch (ExprException exprException) {
                exprException.printStackTrace();
            }

            String resultat = e.toString();

            Log.i("calcul", resultat);
            Toast toast = Toast.makeText(getApplicationContext(),
                    "Le résultat est " + resultat + " ! ",
                    Toast.LENGTH_SHORT);

            toast.show();
        } catch (Exception e)
        {
            System.out.println(e);
        }
    }

    private void deserialiserRessources() {
        bt_un = this.findViewById(R.id.bt_un);
        bt_deux =  this.findViewById(R.id.bt_deux);
        bt_trois = this.findViewById(R.id.bt_trois);
        bt_quatre = this.findViewById(R.id.bt_quatre);
        bt_cinq = this.findViewById(R.id.bt_cinq);
        bt_six = this.findViewById(R.id.bt_six);
        bt_sept = this.findViewById(R.id.bt_sept);
        bt_huit = this.findViewById(R.id.bt_huit);
        bt_neuf = this.findViewById(R.id.bt_neuf);
        bt_zero = this.findViewById(R.id.bt_zero);

        bt_virgule = this.findViewById(R.id.bt_virgule);
        bt_plus = this.findViewById(R.id.bt_plus);
        bt_moins =  this.findViewById(R.id.bt_moins);
        bt_fois = this.findViewById(R.id.bt_fois);
        bt_div = this.findViewById(R.id.bt_div);
        bt_egal = this.findViewById(R.id.bt_egal);

        bt_parentOuv = this.findViewById(R.id.bt_parentOuv);
        bt_parentFerm = this.findViewById(R.id.bt_parentFerm);
        bt_abs = this.findViewById(R.id.bt_abs);
        bt_sqrt =  this.findViewById(R.id.bt_sqrt);
        bt_puiss = this.findViewById(R.id.bt_puiss);
        bt_sin = this.findViewById(R.id.bt_sin);
        bt_cos = this.findViewById(R.id.bt_cos);
        bt_tan = this.findViewById(R.id.bt_tan);
        bt_asin = this.findViewById(R.id.bt_asin);
        bt_acos = this.findViewById(R.id.bt_acos);
        bt_atan = this.findViewById(R.id.bt_atan);
        bt_ln = this.findViewById(R.id.bt_ln);
        bt_log = this.findViewById(R.id.bt_log);
        bt_exp = this.findViewById(R.id.bt_exp);

        bt_ac = this.findViewById(R.id.bt_ac);
        bt_backspace = this.findViewById(R.id.bt_backspace);

        afficheur = this.findViewById(R.id.textView1);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_un:
                afficheur.setText(afficheur.getText() + "1");
                break;
            case R.id.bt_deux:
                afficheur.setText(afficheur.getText() + "2");
                break;
            case R.id.bt_trois:
                afficheur.setText(afficheur.getText() + "3");
                break;
            case R.id.bt_quatre:
                afficheur.setText(afficheur.getText() + "4");
                break;
            case R.id.bt_cinq:
                afficheur.setText(afficheur.getText() + "5");
                break;
            case R.id.bt_six:
                afficheur.setText(afficheur.getText() + "6");
                break;
            case R.id.bt_sept:
                afficheur.setText(afficheur.getText() + "7");
                break;
            case R.id.bt_huit:
                afficheur.setText(afficheur.getText() + "8");
                break;
            case R.id.bt_neuf:
                afficheur.setText(afficheur.getText() + "9");
                break;
            case R.id.bt_zero:
                afficheur.setText(afficheur.getText() + "0");
                break;
            case R.id.bt_virgule:
                afficheur.setText(afficheur.getText() + ".");
                break;
            case R.id.bt_plus:
                afficheur.setText(afficheur.getText() + "+");
                break;
            case R.id.bt_div:
                afficheur.setText(afficheur.getText() + "/");
                break;
            case R.id.bt_moins:
                afficheur.setText(afficheur.getText() + "-");
                break;
            case R.id.bt_fois:
                afficheur.setText(afficheur.getText() + "*");
                break;

            case R.id.bt_parentOuv:
                afficheur.setText(afficheur.getText() + "(");
                break;
            case R.id.bt_parentFerm:
                afficheur.setText(afficheur.getText() + ")");
                break;
            case R.id.bt_abs:
                afficheur.setText(afficheur.getText() + "abs");
                break;
            case R.id.bt_sqrt:
                afficheur.setText(afficheur.getText() + "sqrt");
                break;
            case R.id.bt_puiss:
                afficheur.setText(afficheur.getText() + "^");
                break;
            case R.id.bt_sin:
                afficheur.setText(afficheur.getText() + "sin");
                break;
            case R.id.bt_cos:
                afficheur.setText(afficheur.getText() + "cos");
                break;
            case R.id.bt_tan:
                afficheur.setText(afficheur.getText() + "tan");
                break;
            case R.id.bt_asin:
                afficheur.setText(afficheur.getText() + "asin");
                break;
            case R.id.bt_acos:
                afficheur.setText(afficheur.getText() + "acos");
                break;
            case R.id.bt_atan:
                afficheur.setText(afficheur.getText() + "atan");
                break;
            case R.id.bt_ln:
                afficheur.setText(afficheur.getText() + "ln");
                break;
            case R.id.bt_log:
                afficheur.setText(afficheur.getText() + "log");
                break;
            case R.id.bt_exp:
                afficheur.setText(afficheur.getText() + "exp");
                break;

            case R.id.bt_ac:
                afficheur.setText(null);
                break;

            case R.id.bt_backspace:
                if (afficheur.getText().equals("")){
                    break;
                }
                afficheur.setText(afficheur.getText().subSequence(0, afficheur.getText().length() - 1));
                Log.i("message", "ca marche");
                break;

            case R.id.bt_egal:
                parser();
                break;
        }

        Log.i("message", afficheur.getText().toString());
    }

    /**
     * Mise en place des écouteurs
     */
    public void initConnection(){

        /**
         * Mise en place des écouteurs des boutons commune aux deux types
         * de calculatrices
         */

        bt_un.setOnClickListener(this);
        bt_deux.setOnClickListener(this);
        bt_trois.setOnClickListener(this);
        bt_quatre.setOnClickListener(this);
        bt_cinq.setOnClickListener(this);
        bt_six.setOnClickListener(this);
        bt_sept.setOnClickListener(this);
        bt_huit.setOnClickListener(this);
        bt_neuf.setOnClickListener(this);
        bt_zero.setOnClickListener(this);
        bt_virgule.setOnClickListener(this);
        bt_plus.setOnClickListener(this);
        bt_moins.setOnClickListener(this);
        bt_div.setOnClickListener(this);
        bt_fois.setOnClickListener(this);
        bt_egal.setOnClickListener(this);
        bt_ac.setOnClickListener(this);
        bt_backspace.setOnClickListener(this);


        /**
         * Mise en place des écouteurs relatifs à la calculatrice scientifique uniquement
         */
        Log.i("orientation",""+getScreenOrientation());

        int orientation = this.getScreenOrientation();

        if (orientation == 2) {
            bt_parentOuv.setOnClickListener(this);
            bt_parentFerm.setOnClickListener(this);
            bt_abs.setOnClickListener(this);
            bt_sqrt.setOnClickListener(this);
            bt_puiss.setOnClickListener(this);
            bt_sin.setOnClickListener(this);
            bt_cos.setOnClickListener(this);
            bt_tan.setOnClickListener(this);
            bt_asin.setOnClickListener(this);
            bt_acos.setOnClickListener(this);
            bt_atan.setOnClickListener(this);
            bt_ln.setOnClickListener(this);
            bt_log.setOnClickListener(this);
            bt_exp.setOnClickListener(this);
        }
    }

    /**
     * Détection de l'orientation du terminal
     * @return (int) :
     * * Configuration.ORIENTATION_LANDSCAPE si paysage
     * * Configuration.ORIENTATION_PORTRAIT si portrait
     */
    public int getScreenOrientation()
    {
        Display getOrient = getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if(getOrient.getWidth()==getOrient.getHeight()){
            orientation = Configuration.ORIENTATION_SQUARE;
        } else{
            if(getOrient.getWidth() < getOrient.getHeight()){
                orientation = Configuration.ORIENTATION_PORTRAIT;
            }else {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        return orientation;
    }
}
