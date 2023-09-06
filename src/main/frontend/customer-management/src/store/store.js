import {configureStore} from '@reduxjs/toolkit'
import masterDataSlice from './master-data';

const store = configureStore(
    {
        reducer:{
            masterDataSlice: masterDataSlice.reducer

        }
    }
);

export default store;