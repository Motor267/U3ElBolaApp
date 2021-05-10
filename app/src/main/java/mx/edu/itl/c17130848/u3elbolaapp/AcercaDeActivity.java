/*------------------------------------------------------------------------------------------
:*                         TECNOLOGICO NACIONAL DE MEXICO
:*                       INSTITUTO TECNOLOGICO DE LA LAGUNA
:*                     INGENIERIA EN SISTEMAS COMPUTACIONALES
:*                             DESARROLLO EN ANDROID "A"
:*
:*                   SEMESTRE: ENE-JUN/2021    HORA: 10-11 HRS
:*
:*                  Activity con información acerca de la app
:*
:*  Archivo     : AcercaDeActivity.java
:*  Autor       : Angel Eduardo Soto García    17130848
:*  Fecha       : 20/May/2021
:*  Compilador  : Android Studio 4.1.2
:*  Descripción : Clase que contiene el nombre de la escuela, instituto, del alumno, y nombre
:*                de la aplicación
:*  Ultima modif:
:*  Fecha       Modifición             Motivo
:*==========================================================================================
:*------------------------------------------------------------------------------------------*/

package mx.edu.itl.c17130848.u3elbolaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class AcercaDeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);
    }
}