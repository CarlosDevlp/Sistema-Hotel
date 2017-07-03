/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Date;

/**
 *
 * @author rsoporte
 */
public class dtoHabitacionMantenimiento {
    
    protected int codMantenimiento;
    protected int NumHab;
    protected String TipoHab;
    protected String Personal;

    /**
     * @return the codMantenimiento
     */
    public int getCodMantenimiento() {
        return codMantenimiento;
    }

    /**
     * @param codMantenimiento the codMantenimiento to set
     */
    public void setCodMantenimiento(int codMantenimiento) {
        this.codMantenimiento = codMantenimiento;
    }

    /**
     * @return the NumHab
     */
    public int getNumHab() {
        return NumHab;
    }

    /**
     * @param NumHab the NumHab to set
     */
    public void setNumHab(int NumHab) {
        this.NumHab = NumHab;
    }

    /**
     * @return the TipoHab
     */
    public String getTipoHab() {
        return TipoHab;
    }

    /**
     * @param TipoHab the TipoHab to set
     */
    public void setTipoHab(String TipoHab) {
        this.TipoHab = TipoHab;
    }

    /**
     * @return the Personal
     */
    public String getPersonal() {
        return Personal;
    }

    /**
     * @param Personal the Personal to set
     */
    public void setPersonal(String Personal) {
        this.Personal = Personal;
    }

}
