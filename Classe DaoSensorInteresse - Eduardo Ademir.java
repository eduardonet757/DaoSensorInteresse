// Classe DaoSensorInteresse - Eduardo Ademir
public SensorInteresse getSensorByID(int id) throws ParseException {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABELA_NOME, colunasSensorInteresse, sSensorInteresseIDSelection, new String[]{String.valueOf(id)}, null, null, null);
        SensorInteresse sensor = new SensorInteresse();

        if(cursor.moveToFirst()){

            sensor.setId(cursor.getInt(SENSOR_INTERESSE_ID));
            Date sensorDate = dateFormat.parse(cursor.getString(SENSOR_INTERESSE_DATA_CADASTRO));
            sensor.setDataCadastro(sensorDate);
            sensor.setIdUsuario(cursor.getInt(SENSOR_INTERESSE_ID_USUARIO));
            sensor.setIdSensorPcd(cursor.getInt(SENSOR_INTERESSE_ID_SENSOR));
        }
        cursor.close();

        return sensor;
    }