package com.Boutique.data.supabase

import io.github.jan.supabase.SupabaseClient
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.gotrue.GoTrue
import io.github.jan.supabase.gotrue.gotrue
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.postgrest
import io.github.jan.supabase.storage.Storage
import io.github.jan.supabase.storage.storage

object SupabaseClient {
    private const val SUPABASE_URL = "https://Boutique.supabase.co"
    private const val SUPABASE_KEY = "votre-cle-anon"
    
    val client: SupabaseClient by lazy {
        createSupabaseClient(
            supabaseUrl = SUPABASE_URL,
            supabaseKey = SUPABASE_KEY
        ) {
            install(Postgrest)
            install(GoTrue) {
                alwaysAutoRefresh = true
                flowType = GoTrue.FlowType.PKCE
            }
            install(Storage)
            
            // Configuration supplémentaire
            defaultHeaders {
                "apikey" = SUPABASE_KEY
            }
        }
    }
}