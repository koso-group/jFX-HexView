package craftsolutions.meatsuko.javafx.hexview.dto;

import craftsolutions.meatsuko.javafx.hexview.Math;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.UnsupportedEncodingException;
import java.util.Random;

public class DataRow16
{
    private StringProperty _col_address;
    private StringProperty[] _col_data = new StringProperty[16];

    private byte[] _selfBuffer;

    public DataRow16(int address, byte[] buffer)
    {
        this._col_address = new SimpleStringProperty(String.format("%08X", address));

        //for(int i = 0; i < bytes.length; i++)
            //this._col_data[i] = new SimpleStringProperty(String.format("%02X", bytes[i]));

        this._selfBuffer = buffer;
    }

    public StringProperty addressProperty() { return this._col_address; }

    /* Оптимизашка ))))
    public StringProperty b00Property() { return this._col_data[0]; }
    public StringProperty b01Property() { return this._col_data[1]; }
    public StringProperty b02Property() { return this._col_data[2]; }
    public StringProperty b03Property() { return this._col_data[3]; }
    public StringProperty b04Property() { return this._col_data[4]; }
    public StringProperty b05Property() { return this._col_data[5]; }
    public StringProperty b06Property() { return this._col_data[6]; }
    public StringProperty b07Property() { return this._col_data[7]; }
    public StringProperty b08Property() { return this._col_data[8]; }
    public StringProperty b09Property() { return this._col_data[9]; }
    public StringProperty b0AProperty() { return this._col_data[10]; }
    public StringProperty b0BProperty() { return this._col_data[11]; }
    public StringProperty b0CProperty() { return this._col_data[12]; }
    public StringProperty b0DProperty() { return this._col_data[13]; }
    public StringProperty b0EProperty() { return this._col_data[14]; }
    public StringProperty b0FProperty() { return this._col_data[15]; }
    */

    public StringProperty b00Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[0])); }
    public StringProperty b01Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[1])); }
    public StringProperty b02Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[2])); }
    public StringProperty b03Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[3])); }
    public StringProperty b04Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[4])); }
    public StringProperty b05Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[5])); }
    public StringProperty b06Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[6])); }
    public StringProperty b07Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[7])); }
    public StringProperty b08Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[8])); }
    public StringProperty b09Property() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[9])); }
    public StringProperty b0AProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[10])); }
    public StringProperty b0BProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[11])); }
    public StringProperty b0CProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[12])); }
    public StringProperty b0DProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[13])); }
    public StringProperty b0EProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[14])); }
    public StringProperty b0FProperty() { return new SimpleStringProperty(String.format("%02X", this._selfBuffer[15])); }

    public StringProperty textProperty() throws UnsupportedEncodingException {
        //byte[] buffer = new byte[this._col_data.length];

        //for (int i = 0; i < buffer.length; i++)
            //buffer[i] = Math.hexToByte(this._col_data[i].get());

        return new SimpleStringProperty(new String(this._selfBuffer, "UTF-8"));
    }


    public byte[] getRowBytes()
    {
        return this._selfBuffer;
    }




    public void edit()
    {
        Random random = new Random();
        random.nextBytes(this._selfBuffer);
    }
}
