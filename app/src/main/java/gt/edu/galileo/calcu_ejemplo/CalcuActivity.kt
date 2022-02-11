package gt.edu.galileo.calcu_ejemplo

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import gt.edu.galileo.calcu_ejemplo.databinding.ActivityCalcuBinding

class CalcuActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityCalcuBinding
    private var secondOperator = false
    private var dobleOperation = false
    private var op1 = 0
    private var op2 = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCalcuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.n1.setOnClickListener(this)
        binding.n2.setOnClickListener(this)
        binding.n3.setOnClickListener(this)
        binding.opsuma.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {
            R.id.n1 -> { if (dobleOperation) {
                                    binding.pantalla.text= ""
                                    dobleOperation = false
                        }
                binding.pantalla.text = binding.pantalla.text.toString() + "1"
               }
            R.id.n2 -> {if (dobleOperation) {
                binding.pantalla.text= ""
                dobleOperation = false
                }
                binding.pantalla.text = binding.pantalla.text.toString() + "2"}
            R.id.n3 -> {if (dobleOperation) {
                binding.pantalla.text= ""
                dobleOperation = false
                }
                binding.pantalla.text = binding.pantalla.text.toString() + "3"}
            R.id.opsuma -> {
                if (!secondOperator) {
                    op1 = binding.pantalla.text.toString().toInt()
                    binding.pantalla.text= ""
                    secondOperator = true
                } else {
                    op2 = binding.pantalla.text.toString().toInt()
                    op1 = op1 + op2
                    binding.pantalla.text = op1.toString()
                    dobleOperation = true;
                }
            }
        }
    }
}