package ocr.codeyourlife.com.ocrapp_android.view

import android.Manifest
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ocr.codeyourlife.com.ocrapp_android.R
import java.io.File
import android.provider.MediaStore
import android.content.DialogInterface
import android.support.v7.app.AlertDialog
import android.widget.Toast
import android.graphics.Bitmap
import android.app.Activity
import android.content.Context
import android.content.pm.PackageManager
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import ocr.codeyourlife.com.ocrapp_android.di.DaggerOCRComponent
import ocr.codeyourlife.com.ocrapp_android.model.ImageTextResponse
import ocr.codeyourlife.com.ocrapp_android.service.ServiceUtil
import java.io.ByteArrayOutputStream
import java.io.FileNotFoundException
import java.io.IOException
import javax.inject.Inject


class MainActivity : AppCompatActivity(), MainView {

    protected val CAMERA_REQUEST = 100
    protected val GALLERY_PICTURE = 101
    val MY_PERMISSIONS_REQUEST_CAMERA = 123
    var captureMediaFile: File? = null
    var bytesDocumentsTypePicture: ByteArray? = null
    @Inject
    lateinit  var service: ServiceUtil ;

    override fun onResult() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun showImageText() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
   DaggerOCRComponent.builder().build().inject(this);

        imageButton.setOnClickListener(View.OnClickListener {
            val myAlertDialog = AlertDialog.Builder(this)
            myAlertDialog.setTitle("Upload Pictures Option")
            myAlertDialog.setMessage("How do you want to set your picture?")

            myAlertDialog.setPositiveButton("Gallery", DialogInterface.OnClickListener { arg0, arg1 ->
                val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
                startActivityForResult(intent, GALLERY_PICTURE)
            })

            myAlertDialog.setNegativeButton("Camera", DialogInterface.OnClickListener { arg0, arg1 ->

                if (ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.CAMERA
                    )
                    != PackageManager.PERMISSION_GRANTED
                ) {

                    // Permission is not granted
                    // Should we show an explanation?
                    if (ActivityCompat.shouldShowRequestPermissionRationale(
                            this,
                            Manifest.permission.CAMERA
                        )
                    ) {
                        // Show an explanation to the user *asynchronously* -- don't block
                        // this thread waiting for the user's response! After the user
                        // sees the explanation, try again to request the permission.
                    } else {
                        // No explanation needed, we can request the permission.
                        ActivityCompat.requestPermissions(
                            this,
                            arrayOf(Manifest.permission.CAMERA),
                            CAMERA_PERMISSION
                        )

                        // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                        // app-defined int constant. The callback method gets the
                        // result of the request.
                    }
                } else {
                    // Permission has already been granted

                    val cameraIntent = Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE)
                    startActivityForResult(cameraIntent, CAMERA_REQUEST)
                }

            })
            myAlertDialog.show()
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode === Activity.RESULT_OK && requestCode === CAMERA_REQUEST) {

            val photo = data!!.getExtras().get("data") as Bitmap
            imageButton.setImageBitmap(photo)
            val subscription = service.getImageText(object : ServiceUtil.GetTextCallback {
                override fun onSuccess(imageTextResponse: ImageTextResponse) {
                   textView.setText("The image text:"+imageTextResponse.ocrText)
                }

                override fun onError(networkError: Throwable) {
                    textView.setText("NetworkError:"+networkError.message)
                }

            },"","","",
                bitmapToFile(photo))

          //  subscriptions.add(subscription)
        } else if (resultCode === Activity.RESULT_OK && requestCode === GALLERY_PICTURE) {

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, data!!.data)
            imageButton.setImageBitmap(bitmap)
        } else {
            Toast.makeText(applicationContext, " some_error_while_uploading  ", Toast.LENGTH_SHORT).show()
        }
    }

    private val CAMERA_PERMISSION: Int = 1

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>, grantResults: IntArray
    ) {
        when (requestCode) {
            CAMERA_PERMISSION -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                }
                return
            }

            // Add other 'when' lines to check for other
            // permissions this app might request.
            else -> {
                // Ignore all other requests.
            }

        }
    }
    fun bitmapToFile(bmp: Bitmap): File? {
        try {

            val bos = ByteArrayOutputStream(bmp.byteCount)
            bmp.compress(Bitmap.CompressFormat.PNG, 80, bos)
            val bArr = bos.toByteArray()
            bos.flush()
            bos.close()

            val fos = openFileOutput("mdroid.png", Context.MODE_WORLD_WRITEABLE)
            fos.write(bArr)
            fos.flush()
            fos.close()

            return File(getFilesDir().getAbsolutePath(), "mdroid.png")
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            return null
        } catch (e: IOException) {
            e.printStackTrace()
            return null
        }

    }
}