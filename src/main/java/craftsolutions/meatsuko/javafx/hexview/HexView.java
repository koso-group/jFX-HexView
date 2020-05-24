package craftsolutions.meatsuko.javafx.hexview;


import com.sun.javafx.collections.ObservableListWrapper;
import craftsolutions.meatsuko.javafx.hexview.dto.DataRow16;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Random;


public class HexView extends TableView
{

    @FXML
    protected TableView<DataRow16> table_hex;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_address;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b00;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b01;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b02;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b03;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b04;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b05;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b06;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b07;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b08;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b09;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0A;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0B;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0C;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0D;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0E;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_b0F;

    @FXML
    protected TableColumn<DataRow16, StringProperty> column_text;


    protected ObservableListWrapper<DataRow16> observableListWrapper;


    public HexView()
    {
        try
        {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/hexView.fxml"));

            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        }
        catch (IOException ioException)
        {
            ioException.printStackTrace();
            return;
        }

        this.column_address.setCellValueFactory(new PropertyValueFactory<>("address"));
        this.column_b00.setCellValueFactory(new PropertyValueFactory<>("b00"));
        this.column_b01.setCellValueFactory(new PropertyValueFactory<>("b01"));
        this.column_b02.setCellValueFactory(new PropertyValueFactory<>("b02"));
        this.column_b03.setCellValueFactory(new PropertyValueFactory<>("b03"));
        this.column_b04.setCellValueFactory(new PropertyValueFactory<>("b04"));
        this.column_b05.setCellValueFactory(new PropertyValueFactory<>("b05"));
        this.column_b06.setCellValueFactory(new PropertyValueFactory<>("b06"));
        this.column_b07.setCellValueFactory(new PropertyValueFactory<>("b07"));
        this.column_b08.setCellValueFactory(new PropertyValueFactory<>("b08"));
        this.column_b09.setCellValueFactory(new PropertyValueFactory<>("b09"));
        this.column_b0A.setCellValueFactory(new PropertyValueFactory<>("b0A"));
        this.column_b0B.setCellValueFactory(new PropertyValueFactory<>("b0B"));
        this.column_b0C.setCellValueFactory(new PropertyValueFactory<>("b0C"));
        this.column_b0D.setCellValueFactory(new PropertyValueFactory<>("b0D"));
        this.column_b0E.setCellValueFactory(new PropertyValueFactory<>("b0E"));
        this.column_b0F.setCellValueFactory(new PropertyValueFactory<>("b0F"));
        this.column_text.setCellValueFactory(new PropertyValueFactory<>("text"));

        this.table_hex.getSelectionModel().setCellSelectionEnabled(true);
        this.table_hex.setEditable(false);

        this.table_hex.getColumns().forEach((column) ->
        {
            column.impl_setReorderable(false);
            //column.setCellFactory(cast(TextFieldTableCell.forTableColumn()));
            column.setStyle("-fx-alignment: CENTER; -fx-font-family: Consolas;");
        });

        this.table_hex.getColumns().get(0).setStyle("-fx-alignment: CENTER-RIGHT; -fx-font-family: Consolas;");

        this.observableListWrapper = (ObservableListWrapper<DataRow16>) this.table_hex.itemsProperty().get();
    }


    public void setByteBuffer(byte[] buffer)
    {
        this.observableListWrapper.clear();

        this.appendByteBuffer(buffer);

    }

    public byte[] getByteBuffer()
    {
        int bufferLength = this.observableListWrapper.size() * 16;
        ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[bufferLength]);

        this.observableListWrapper.forEach(dataRow16 -> byteBuffer.put(dataRow16.getRowBytes()));

        return byteBuffer.array();
    }

    public void appendByteBuffer(byte[] buffer)
    {
        byte[] bufferPart;
        int address = 0;
        while(!(address >= buffer.length))
        {
            bufferPart = new byte[16];

            for(int i = 0; i < 16; i++)
                try
                {
                    bufferPart[i] = buffer[address + i];
                }
                catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){}


            this.observableListWrapper.add(new DataRow16(address, bufferPart));

            address += 16;
        }
    }



    public TableView<DataRow16> impl_getTableViewControl() { return this.table_hex; }
    public ObservableListWrapper<DataRow16> impl_getObservableListWrapper() { return this.observableListWrapper;  }
}
