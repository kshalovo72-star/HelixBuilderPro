package com.helixbuilderpro.model

/**
 * Parameters used by the future 3D generator.
 */
data class Helix3DParameters(
    val turns: Int = 12,
    val coilDiameterMm: Double = 50.0,
    val pitchMm: Double = 10.0,
    val wireDiameterMm: Double = 2.0,
    val reflectorDiameterMm: Double = 120.0
)
