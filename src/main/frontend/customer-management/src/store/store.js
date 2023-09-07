import {configureStore} from '@reduxjs/toolkit'
import masterDataSlice from './master-data';
import UIFieldStoreSlice from './ui-field-store'

const store = configureStore(
    {
        reducer:{
            masterDataSlice: masterDataSlice.reducer,
            UIFieldStoreSlice: UIFieldStoreSlice.reducer

        }
    }
);

export default store;