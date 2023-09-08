import {configureStore} from '@reduxjs/toolkit'
import masterDataSlice from './master-data';
import UIFieldStoreSlice from './ui-field-store'
import UserStoreSlice from './user-store'

const store = configureStore(
    {
        reducer:{
            masterDataSlice: masterDataSlice.reducer,
            UIFieldStoreSlice: UIFieldStoreSlice.reducer,
            UserStoreSlice: UserStoreSlice.reducer

        }
    }
);

export default store;