package com.example.at_bmthngtin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class MaHoaModuloActivity extends AppCompatActivity {

    private EditText editTextNumber1, editTextNumber2, editTextNumber3, editTextNumber4, editTextNumber5;
    private Button buttonSubmit3, buttonClean3;
    private TextView textViewResult3, textViewBaiToan3;
    private TextInputLayout textInputLayout1, textInputLayout2, textInputLayout3, textInputLayout4, textInputLayout5;
    private TinhModulo modulo = new TinhModulo();
    private int val, number1, number2, number3, number4, number5, numberHm;
    private Toast toast;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ma_hoa_modulo);
        editTextNumber1 = findViewById(R.id.editTextNumber1);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        editTextNumber3 = findViewById(R.id.editTextNumber3);
        editTextNumber4 = findViewById(R.id.editTextNumber4);
        editTextNumber5 = findViewById(R.id.editTextNumber5);
        textViewResult3 = findViewById(R.id.textViewResult3);
        textViewBaiToan3 = findViewById(R.id.textViewBaiToan3);
        buttonSubmit3 = findViewById(R.id.buttonSubmit3);
        buttonClean3 = findViewById(R.id.buttonClean3);
        textInputLayout1 = findViewById(R.id.textInputLayout1);
        textInputLayout2 = findViewById(R.id.textInputLayout2);
        textInputLayout3 = findViewById(R.id.textInputLayout3);
        textInputLayout4 = findViewById(R.id.textInputLayout4);
        textInputLayout5 = findViewById(R.id.textInputLayout5);
        //
        textViewResult3.setMovementMethod(new ScrollingMovementMethod());

        // Nh???n d??? li???u chuy???n activity
        Intent intent = getIntent();
        Bundle bundle = intent.getBundleExtra("MaHoaModulo");
        val = bundle.getInt("key");
        switch (val) {
            case 0: {
                textViewBaiToan3.setText("Trao ?????i kh??a Diffie-Hellman\nq - l?? s??? nguy??n t???\na - l?? C??n nguy??n th???y c???a q\nCh???n xA, xB\nyA = a^xA mod q\nyB = a^xB mod q\nKa = yB^xA mod q\nKb = yA^xB mod q");
                editHintText("q", "a", "xA", "xB", "Null");
                break;
            }
            case 1: {
                textViewBaiToan3.setText("Thu???t to??n RSA - B??i to??n 1\np,q l?? 2 s??? nguy??n t??? kh??c nhau\nn = p*q\nCh???n e (gcd(e,??n) = 1; 1 < e < ??n)\nd = e^(-1) mod ??n\nPU = { e, n }\nPR = { d, n }\nB???n g???c: M < n\nD??ng kh??a Ri??ng ????? m?? h??a(PR)  \nC = M^d mod n\nD??ng kh??a Chung ????? gi???i m??(PU)\nM = C^e mod n");
                editHintText("p", "q", "e", "M", "Null");

                break;
            }
            case 2: {
                textViewBaiToan3.setText("Thu???t to??n RSA - B??i to??n 2\np,q l?? 2 s??? nguy??n t??? kh??c nhau\nn = p*q\nCh???n e (gcd(e,??n) = 1; 1 < e < ??n)\nd = e^(-1) mod ??n\nPU = { e, n }\nPR = { d, n }\n B???n g???c: M < n\nD??ng kh??a Chung ????? m?? h??a(PU)\nC = M^e mod n\nD??ng kh??a Ri??ng ????? gi???i m??(PR)  \nM = C^d mod n");
                editHintText("p", "q", "e", "M", "Null");
                break;
            }
            case 3: {
                textViewBaiToan3.setText("M???t m?? ElGamal\nq - l?? s??? nguy??n t???\na - l?? C??n nguy??n th???y c???a q\nCh???n xA < q-1\nyA = a^xA mod q\nPU = { q, a, yA}\n B???n g???c: M < q\n M?? h??a:\n Ch???n k < q\n K = yA^k mod q\nC1 = a^k mod q\nC2 = K*M mod q\nGi???i m??:\nK = C1^xA mod q\n M = (C2*K^(-1)) mod q");
                editHintText("q", "a", "xA", "k", "M");
                break;
            }
            case 4: {
                textViewBaiToan3.setText("Ch??? k?? ??i???n t??? DSA\n" +
                        "p s??? nguy??n t???" +
                        "\nq l?? ?????c s??? nguy??n t??? c???a p-1" +
                        "\nh l?? s??? nguy??n 1 < h < (p-1) \n    sao cho g = h^((p-1)/q) mod p > 1" +
                        "\n0 < x < q" +
                        "\ny = g^x mod p" +
                        "\n0 < k < q" +
                        "\nr = (g^k mod p) mod q" +
                        "\ns = [k^(-1) * (H(M) + x * r)] mod q" +
                        "\nCh??? k?? s??? l?? (r, s)" +
                        "\nTa c?? r' = r, s' = s, M' = M" +
                        "\nw = (s')^-1 mod q" +
                        "\nu1 = (H(M) * w) mod q" +
                        "\nu2 = (r' * w) mod q" +
                        "\nv = [(g^u1 * y^u2) mod p] mod q" +
                        "\nKi???m tra n???u v = r' => ????ng");
                editHintText("p", "q", "h-H(M)", "xA", "k");
                break;
            }
            default:
                toast = Toast.makeText(MaHoaModuloActivity.this, "Ch??a c??!!!", Toast.LENGTH_SHORT);
                toast.show();

        }

        // set scroll cho text view
        textViewBaiToan3.setMovementMethod(new ScrollingMovementMethod());
        // Click Button Clean
        buttonClean3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Clean();
            }
        });
        // Click Button Ket Qua
        buttonSubmit3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    toast = Toast.makeText(MaHoaModuloActivity.this, "Nh???p ch??a ????? d??? ki???n ????? b??i!!!", Toast.LENGTH_SHORT);
                    String edt1, edt2, edt3, edt4, edt5;
                    edt1 = editTextNumber1.getText().toString();
                    edt2 = editTextNumber2.getText().toString();
                    edt3 = editTextNumber3.getText().toString();
                    edt4 = editTextNumber4.getText().toString();
                    edt5 = editTextNumber5.getText().toString();
                    if (edt1.length() == 0 || edt2.length() == 0 || edt3.length() == 0 || edt4.length() == 0) {
                        toast.show();
                    } else {
                        if (edt5.length() == 0 && (val == 4 || val == 3)) {
                            toast.show();
                        } else {
                            if (edt5.length() != 0 && (val == 4 || val == 3)) {
                                number5 = Integer.parseInt(edt5);
                                if (val == 4) {
                                    number3 = Integer.parseInt(edt3.split("-")[0]);
                                    numberHm = Integer.parseInt(edt3.split("-")[1]);
                                } else {
                                    number3 = Integer.parseInt(edt3);
                                }
                            } else {
                                number3 = Integer.parseInt(edt3);
                            }
                        }
                        number1 = Integer.parseInt(edt1);
                        number2 = Integer.parseInt(edt2);
                        number4 = Integer.parseInt(edt4);
                        switch (val) {
                            case 0: {
                                textViewResult3.setText(Diffie_Hellman(number1, number2, number3, number4));
                                break;
                            }
                            case 1: {
                                textViewResult3.setText(RSA_BT1(number1, number2, number3, number4));
                                break;
                            }
                            case 2: {
                                textViewResult3.setText(RSA_BT2(number1, number2, number3, number4));
                                break;
                            }
                            case 3: {
                                textViewResult3.setText(ElGamal(number1, number2, number3, number4, number5));
                                break;
                            }
                            case 4: {
                                textViewResult3.setText(ChuKyDienTu(number1, number2, number3, number4, number5, numberHm));
                                break;
                            }

                            default:
                                Toast.makeText(MaHoaModuloActivity.this, "Ch??a c??!!!", Toast.LENGTH_SHORT).show();

                        }
                    }
                } catch (Exception e) {
                    toast = Toast.makeText(MaHoaModuloActivity.this, e.getMessage(), Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });

    }

    public void Clean() {
        editTextNumber1.setText("");
        editTextNumber1.requestFocus();
        editTextNumber2.setText("");
        editTextNumber3.setText("");
        editTextNumber4.setText("");
        editTextNumber5.setText("");
    }


    public void editHintText(String ed1, String ed2, String ed3, String ed4, String ed5) {
        textInputLayout1.setHint(ed1);
        textInputLayout2.setHint(ed2);
        textInputLayout3.setHint(ed3);
        textInputLayout4.setHint(ed4);
        textInputLayout5.setHint(ed5);
        if (ed5.equals("Null")) {
            textInputLayout5.setVisibility(View.INVISIBLE);
        } else {
            textInputLayout5.setVisibility(View.VISIBLE);
        }

    }

    public String Diffie_Hellman(int q, int a, int xA, int xB) {
        String result3;
        long yA, yB, Ka, Kb;
        if (xA < q && xB < q && modulo.isPrime(q) && modulo.isCanNguyenThuy(a, q) && a < q) {
            yA = modulo.power(a, xA, q);
            yB = modulo.power(a, xB, q);
            Ka = modulo.power((int) yB, xA, q);
            Kb = modulo.power((int) yA, xB, q);
            result3 = "yA = " + yA + "\nKa = " + Ka + "\nyB = " + yB + "\nKb = " + Kb;
        } else {
            result3 = "D??? li???u v??o kh??ng ch??nh x??c!";
        }
        return result3;
    }

    // D??ng kh??a ri??ng ????? m?? h??a v?? kh??a chung ????? gi???i m??
    private String RSA_BT1(int p, int q, int e, int Ma) {
        String result3;
        int n, nPhi, d;
        long Mb, C;
        if (p != q && modulo.isPrime(q) && modulo.isPrime(p)) {
            n = p * q;
            nPhi = (p - 1) * (q - 1);
            if (1 < e && e < nPhi && modulo.gcd(nPhi, e) == 1) {
                d = modulo.modulo_inverse(e, nPhi);
                C = modulo.power(Ma, d, n); // D??ng kh??a ri??ng ????? m?? h??a
                Mb = modulo.power((int) C, e, n); // Kh??a chung ????? gi???i m??
                result3 = "PU = {" + e + ", " + n + "}\nPR = {" + d + ", " + n + "}\nC = " + C + "\nM(B) = " + Mb;
            } else {
                result3 = "e Kh??ng h???p l???!!!";
            }
        } else {
            result3 = "D??? li???u v??o kh??ng ch??nh x??c!";
        }
        return result3;
    }

    // D??ng kh??a chung ????? m?? h??a v?? kh??a ri??ng ????? gi???i m??
    private String RSA_BT2(int p, int q, int e, int Ma) {
        String result3;
        int n, nPhi, d;
        long Mb, C;
        if (p != q && modulo.isPrime(q) && modulo.isPrime(p)) {
            n = p * q;
            nPhi = (p - 1) * (q - 1);
            if (1 < e && e < nPhi && modulo.gcd(nPhi, e) == 1) {
                d = modulo.modulo_inverse(e, nPhi);
                C = modulo.power(Ma, e, n); // D??ng kh??a chung ????? m?? h??a
                Mb = modulo.power((int) C, d, n); // Kh??a ri??ng ????? gi???i m??
                result3 = "PU = {" + e + ", " + n + "}\nPR = {" + d + ", " + n + "}\nC = " + C + "\nM(B) = " + Mb;
            } else {
                result3 = "e Kh??ng h???p l???!!!" + e;
            }
        } else {
            result3 = "D??? li???u v??o kh??ng ch??nh x??c!";
        }
        return result3;
    }

    private String ElGamal(int q, int a, int xA, int k, int M) {
        String result3;
        long yA, Kb, C1, C2, Ka, Ma;
        if (modulo.isPrime(q) && modulo.isCanNguyenThuy(a, q) && a < q && xA < q - 1 && M < q && k < q) {
            yA = modulo.power(a, xA, q);
            Kb = modulo.power((int) yA, k, q);
            C1 = modulo.power(a, k, q);
            C2 = modulo.power((int) Kb * M, 1, q);
            Ka = modulo.power((int) C1, xA, q);
            int var = modulo.modulo_inverse((int) Ka, q);
            Ma = modulo.power((int) C2 * var, 1, q);
            result3 = "PU = {q, a, YA}\nyA = " + yA + "}\nC1 = " + C1 + "\nC2 = " + C2 + "\nKb = " + Kb + "\nKa = " + Ka + "\nMa = " + Ma;
        } else {
            result3 = "D??? li???u v??o kh??ng ch??nh x??c!";
        }
        return result3;
    }

    private String ChuKyDienTu(int p, int q, int h, int xA, int k, int hm) {
        long g, yA, r, s, var1, u1, u2, v, var3, var4;
        String result3 = "\nv = r' => ????ng";
        int var2, w;
        if (xA < q && xA > 0 && h > 1 && h < p - 1 && modulo.power(h, (int) ((p - 1) / q), p) > 1 && modulo.isPrime(p) && modulo.isPrime(q) && (p - 1) % q == 0) {
            g = modulo.power(h, (p - 1) / q, p); // g = h^((p-1))/q) mod p
            yA = modulo.power((int) g, xA, p); // y = g^x mod p
            var1 = modulo.power((int) g, k, p); // = g^k mod p
            r = modulo.power((int) var1, 1, q); // r = (g^k mod p) mod q
            var2 = modulo.modulo_inverse(k, q); // = k^-1 mod q
            s = modulo.power((int) (var2 * (hm + xA * r)), 1, q);  // s = [k^-1 (H(M) + xA * r)] mod q
            /*
             *  Ch?? ??: ph???n x??c minh s??? l???y c??c gi?? tr??? s' = s, M' = M, r' = r
             * */
            w = modulo.modulo_inverse((int) s, q); // w = (s')^-1 mod q
            u1 = modulo.power((hm * w), 1, q); // u1 = (H(M) * w) mod q
            u2 = modulo.power((int) (r * w), 1, q); // u2 = (r' * w) mod q
            var3 = modulo.power((int) g, (int) u1, p); // = g^u1 mod p
            var4 = modulo.power((int) yA, (int) u2, p); // = y^u2 mod p
            v = modulo.power(modulo.power((int) (var3 * var4), 1, p), 1, q); // [(g^u1 * y^u2) mod p] mod q
            if (v != r) {
                result3 = "\nv != r' => Sai";
            }
            return "g = " + g + "\ny = " + yA + "\ng^k mod p = " + var1 + "\nk^-1 mod q = " + var2 + "\nr = " + r + ", s = " + s + "\nw = " + w + "\nu1 = " + u1 + ", u2 = " + u2 + "\ng^u1 mod p = " + var3 + "\ny^u2 mod p = " + var4 + "\nv = " + v + result3;
        } else {
            return "D??? li???u v??o kh??ng ch??nh x??c!";
        }
    }


}
