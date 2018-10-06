/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Controller;


/* El servidor va a poder atender las siguientes peticiones:
 * INSCRIBIR: recibe los datos de un participante y las tres
 *            disciplinas en las que participará
 * SOLICITAR_DISCIPLINA: recibe un tipo de disciplina para que el
 *            servidor le envie los datos de tres participantes
 *            inscritos.
 * ENVIAR_RESULTADO: recibe los puntos acumulados por un participante
 *            luego de participar en una competencia.
*/
public enum AccionesServidor {
    REGISTRAR_USUARIO, DESACTIVAR_USUARIO, REVISAR_USUARIO, ENVIAR_ARCHIVO
}
