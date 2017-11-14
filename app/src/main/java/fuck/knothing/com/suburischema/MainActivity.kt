package fuck.knothing.com.suburischema

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }


    /**
     * 初始化控件
     */
    private fun initView() {

        //方式一
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(View.OnClickListener {
            val main = Intent(Intent.ACTION_VIEW,Uri.parse("urischeme://project.urischeme.com:3344/holly"))
            //保证新启动的APP有单独的堆栈，如果希望新启动的APP和原有APP使用同一个堆栈则去掉该项
//            main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                startActivity(main)
            } catch (e:Exception) {
                e.printStackTrace();
                Toast.makeText(this,"没有匹配的APP，请下载安装",Toast.LENGTH_SHORT).show()
            }
        })


        //方式二
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener(View.OnClickListener {
            val data = Uri.parse("secondurischeme://auth_activity")
            val main = Intent(Intent.ACTION_VIEW,data)
//            main.setData(Uri.parse("secondurischeme"))
            //保证新启动的APP有单独的堆栈，如果希望新启动的APP和原有APP使用同一个堆栈则去掉该项
//            main.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            try {
                startActivity(main)
            } catch (e:Exception) {
                e.printStackTrace();
                Toast.makeText(this,"没有匹配的APP，请下载安装",Toast.LENGTH_SHORT).show()
            }
        })
    }

}
