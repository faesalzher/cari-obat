package swing;

import java.util.HashMap;
import java.util.Map;

public class knn {

    String obat[] = new String[]{" ", "Acetaminophen", "Aciclovir", "Aethanolum", "Aluminium hydroxide", "Aminophylline", "Ammonium chloride", "Asam Mefenamat",
        "Asetaminofen", "Asetilkolin", "Benzocaine", "Benzydamine HCl", "Betahistin mesilat", "Bisacodyl", "Bromhexine HCI", "Caffeine", "Cetylpyridinium Chloride",
        "Champora", "Chlorpheniramine Maleate", "Copper Sulfate", "Dextromethorphan HBr", "Diklofenak bebas", "Dimenhydrinate", "Diphenhydramine HCI", "Donepezil HCl",
        "Ephedrine HCI", "Ferrous Fumarate", "Ferrous gluconate", "FlavonoidFraction", "Folic acid", "Glyceryl Guaiacolate", "Graptophylli folium extrac", "graptophyllum pictum folia",
        "Guaiafenesin", "Ibuprofen", "Koloidal", "Magnesium hydroxide", "manganese sulfate", "Natrium fero (II) sitrat", "Neomycin", "Ol.Campulhora", "Ol.Menthae", "Paracetamol",
        "phenylephrin", "Phenylpropanoiamine HCI", "Piperazine citrate", "Polymyxin B sulfate", "Propyphenazone", "Prornethazine HCI", "Pseudoephedrine", "Pseudoephedrine HCl",
        "Pyrantel pamoate", "Rivastigmine hydrogen tartrate", "Salbutamol sulfate", "Simetikon", "Succus Liquiritae", "Teofilin anhidrat", "Terbutaline sulfate", "Theophylline",
        "Thymol", "Triprolidine", "Vitamin B12", "Zinc sulphate"};
    double data[][] = new double[][]{
{60.0,1.0,1.0,1.0},{1.0,60.0,1.0,1.0},{1.0,1.0,60.0,1.0},{60.0,1.0,1.0,1.0},{1.0,60.0,1.0,1.0},{1.0,1.0,60.0,1.0},
{26.0,60.0,1.0,1.0},{60.0,26.0,1.0,1.0},{60.0,1.0,26.0,1.0},{26.0,1.0,60.0,1.0},{1.0,26.0,60.0,1.0},{1.0,60.0,26.0,1.0},
{6.0,1.0,1.0,1.0},{1.0,6.0,1.0,1.0},{1.0,1.0,6.0,1.0},{6.0,1.0,1.0,1.0},{1.0,6.0,1.0,1.0},{1.0,1.0,6.0,1.0},
{26.0,58.0,1.0,1.0},{58.0,26.0,1.0,1.0},{58.0,1.0,26.0,1.0},{26.0,1.0,58.0,1.0},{1.0,26.0,58.0,1.0},{1.0,58.0,26.0,1.0},
{19.0,1.0,1.0,2.0},{1.0,19.0,1.0,2.0},{1.0,1.0,19.0,2.0},{19.0,1.0,1.0,2.0},{1.0,19.0,1.0,2.0},{1.0,1.0,19.0,2.0},
{19.0,1.0,1.0,3.0},{1.0,19.0,1.0,3.0},{1.0,1.0,19.0,3.0},{19.0,1.0,1.0,3.0},{1.0,19.0,1.0,3.0},{1.0,1.0,19.0,3.0},
{50.0,1.0,1.0,4.0},{1.0,50.0,1.0,4.0},{1.0,1.0,50.0,4.0},{50.0,1.0,1.0,4.0},{1.0,50.0,1.0,4.0},{1.0,1.0,50.0,4.0},
{50.0,1.0,1.0,5.0},{1.0,50.0,1.0,5.0},{1.0,1.0,50.0,5.0},{50.0,1.0,1.0,5.0},{1.0,50.0,1.0,5.0},{1.0,1.0,50.0,5.0},
{44.0,21.0,19.0,6.0},{21.0,44.0,19.0,6.0},{21.0,19.0,44.0,6.0},{44.0,19.0,21.0,6.0},{19.0,44.0,21.0,6.0},{19.0,21.0,44.0,6.0},
{35.0,1.0,1.0,6.0},{1.0,35.0,1.0,6.0},{1.0,1.0,35.0,6.0},{35.0,1.0,1.0,6.0},{1.0,35.0,1.0,6.0},{1.0,1.0,35.0,6.0},
{35.0,1.0,1.0,7.0},{1.0,35.0,1.0,7.0},{1.0,1.0,35.0,7.0},{35.0,1.0,1.0,7.0},{1.0,35.0,1.0,7.0},{1.0,1.0,35.0,7.0},
{15.0,1.0,1.0,8.0},{1.0,15.0,1.0,8.0},{1.0,1.0,15.0,8.0},{15.0,1.0,1.0,8.0},{1.0,15.0,1.0,8.0},{1.0,1.0,15.0,8.0},
{44.0,57.0,7.0,6.0},{57.0,44.0,7.0,6.0},{57.0,7.0,44.0,6.0},{44.0,7.0,57.0,6.0},{7.0,44.0,57.0,6.0},{7.0,57.0,44.0,6.0},
{21.0,7.0,24.0,9.0},{7.0,21.0,24.0,9.0},{7.0,24.0,21.0,9.0},{21.0,24.0,7.0,9.0},{24.0,21.0,7.0,9.0},{24.0,7.0,21.0,9.0},
{21.0,7.0,24.0,4.0},{7.0,21.0,24.0,4.0},{7.0,24.0,21.0,4.0},{21.0,24.0,7.0,4.0},{24.0,21.0,7.0,4.0},{24.0,7.0,21.0,4.0},
{21.0,1.0,1.0,9.0},{1.0,21.0,1.0,9.0},{1.0,1.0,21.0,9.0},{21.0,1.0,1.0,9.0},{1.0,21.0,1.0,9.0},{1.0,1.0,21.0,9.0},
{15.0,1.0,1.0,8.0},{1.0,15.0,1.0,8.0},{1.0,1.0,15.0,8.0},{15.0,1.0,1.0,8.0},{1.0,15.0,1.0,8.0},{1.0,1.0,15.0,8.0},
{26.0,31.0,44.0,6.0},{31.0,26.0,44.0,6.0},{31.0,44.0,26.0,6.0},{26.0,44.0,31.0,6.0},{44.0,26.0,31.0,6.0},{44.0,31.0,26.0,6.0},
{46.0,44.0,21.0,6.0},{44.0,46.0,21.0,6.0},{44.0,21.0,46.0,6.0},{46.0,21.0,44.0,6.0},{21.0,46.0,44.0,6.0},{21.0,44.0,46.0,6.0},
{24.0,1.0,1.0,6.0},{1.0,24.0,1.0,6.0},{1.0,1.0,24.0,6.0},{24.0,1.0,1.0,6.0},{1.0,24.0,1.0,6.0},{1.0,1.0,24.0,6.0},
{24.0,1.0,1.0,8.0},{1.0,24.0,1.0,8.0},{1.0,1.0,24.0,8.0},{24.0,1.0,1.0,8.0},{1.0,24.0,1.0,8.0},{1.0,1.0,24.0,8.0},
{21.0,1.0,1.0,9.0},{1.0,21.0,1.0,9.0},{1.0,1.0,21.0,9.0},{21.0,1.0,1.0,9.0},{1.0,21.0,1.0,9.0},{1.0,1.0,21.0,9.0},
{24.0,7.0,1.0,8.0},{7.0,24.0,1.0,8.0},{7.0,1.0,24.0,8.0},{24.0,1.0,7.0,8.0},{1.0,24.0,7.0,8.0},{1.0,7.0,24.0,8.0},
{19.0,21.0,34.0,1.0},{21.0,19.0,34.0,1.0},{21.0,34.0,19.0,1.0},{19.0,34.0,21.0,1.0},{34.0,19.0,21.0,1.0},{34.0,21.0,19.0,1.0},
{19.0,21.0,34.0,9.0},{21.0,19.0,34.0,9.0},{21.0,34.0,19.0,9.0},{19.0,34.0,21.0,9.0},{34.0,19.0,21.0,9.0},{34.0,21.0,19.0,9.0},
{19.0,21.0,34.0,10.0},{21.0,19.0,34.0,10.0},{21.0,34.0,19.0,10.0},{19.0,34.0,21.0,10.0},{34.0,19.0,21.0,10.0},{34.0,21.0,19.0,10.0},
{21.0,26.0,34.0,6.0},{26.0,21.0,34.0,6.0},{26.0,34.0,21.0,6.0},{21.0,34.0,26.0,6.0},{34.0,21.0,26.0,6.0},{34.0,26.0,21.0,6.0},
{15.0,21.0,34.0,6.0},{21.0,15.0,34.0,6.0},{21.0,34.0,15.0,6.0},{15.0,34.0,21.0,6.0},{34.0,15.0,21.0,6.0},{34.0,21.0,15.0,6.0},
{15.0,21.0,34.0,9.0},{21.0,15.0,34.0,9.0},{21.0,34.0,15.0,9.0},{15.0,34.0,21.0,9.0},{34.0,15.0,21.0,9.0},{34.0,21.0,15.0,9.0},
{37.0,1.0,34.0,11.0},{1.0,37.0,34.0,11.0},{1.0,34.0,37.0,11.0},{37.0,34.0,1.0,11.0},{34.0,37.0,1.0,11.0},{34.0,1.0,37.0,11.0},
{37.0,1.0,34.0,12.0},{1.0,37.0,34.0,12.0},{1.0,34.0,37.0,12.0},{37.0,34.0,1.0,12.0},{34.0,37.0,1.0,12.0},{34.0,1.0,37.0,12.0},
{44.0,45.0,34.0,6.0},{45.0,44.0,34.0,6.0},{45.0,34.0,44.0,6.0},{44.0,34.0,45.0,6.0},{34.0,44.0,45.0,6.0},{34.0,45.0,44.0,6.0},
{44.0,51.0,21.0,6.0},{51.0,44.0,21.0,6.0},{51.0,21.0,44.0,6.0},{44.0,21.0,51.0,6.0},{21.0,44.0,51.0,6.0},{21.0,51.0,44.0,6.0},
{2.0,34.0,19.0,6.0},{34.0,2.0,19.0,6.0},{34.0,19.0,2.0,6.0},{2.0,19.0,34.0,6.0},{19.0,2.0,34.0,6.0},{19.0,34.0,2.0,6.0},
{2.0,45.0,19.0,6.0},{45.0,2.0,19.0,6.0},{45.0,19.0,2.0,6.0},{2.0,19.0,45.0,6.0},{19.0,2.0,45.0,6.0},{19.0,45.0,2.0,6.0},
{33.0,1.0,1.0,13.0},{1.0,33.0,1.0,13.0},{1.0,1.0,33.0,13.0},{33.0,1.0,1.0,13.0},{1.0,33.0,1.0,13.0},{1.0,1.0,33.0,13.0},
{53.0,1.0,1.0,16.0},{1.0,53.0,1.0,16.0},{1.0,1.0,53.0,16.0},{53.0,1.0,1.0,16.0},{1.0,53.0,1.0,16.0},{1.0,1.0,53.0,16.0},
{31.0,1.0,1.0,8.0},{1.0,31.0,1.0,8.0},{1.0,1.0,31.0,8.0},{31.0,1.0,1.0,8.0},{1.0,31.0,1.0,8.0},{1.0,1.0,31.0,8.0},
{4.0,38.0,56.0,14.0},{38.0,4.0,56.0,14.0},{38.0,56.0,4.0,14.0},{4.0,56.0,38.0,14.0},{56.0,4.0,38.0,14.0},{56.0,38.0,4.0,14.0},
{51.0,62.0,1.0,6.0},{62.0,51.0,1.0,6.0},{62.0,1.0,51.0,6.0},{51.0,1.0,62.0,6.0},{1.0,51.0,62.0,6.0},{1.0,62.0,51.0,6.0},
{44.0,31.0,26.0,9.0},{31.0,44.0,26.0,9.0},{31.0,26.0,44.0,9.0},{44.0,26.0,31.0,9.0},{26.0,44.0,31.0,9.0},{26.0,31.0,44.0,9.0},
{59.0,1.0,1.0,1.0},{1.0,59.0,1.0,1.0},{1.0,1.0,59.0,1.0},{59.0,1.0,1.0,1.0},{1.0,59.0,1.0,1.0},{1.0,1.0,59.0,1.0},
{55.0,1.0,1.0,1.0},{1.0,55.0,1.0,1.0},{1.0,1.0,55.0,1.0},{55.0,1.0,1.0,1.0},{1.0,55.0,1.0,1.0},{1.0,1.0,55.0,1.0},
{62.0,51.0,44.0,6.0},{51.0,62.0,44.0,6.0},{51.0,44.0,62.0,6.0},{62.0,44.0,51.0,6.0},{44.0,62.0,51.0,6.0},{44.0,51.0,62.0,6.0},
{44.0,1.0,1.0,6.0},{1.0,44.0,1.0,6.0},{1.0,1.0,44.0,6.0},{44.0,1.0,1.0,6.0},{1.0,44.0,1.0,6.0},{1.0,1.0,44.0,6.0},
{2.0,1.0,1.0,17.0},{1.0,2.0,1.0,17.0},{1.0,1.0,2.0,17.0},{2.0,1.0,1.0,17.0},{1.0,2.0,1.0,17.0},{1.0,1.0,2.0,17.0},
{28.0,20.0,1.0,15.0},{20.0,28.0,1.0,15.0},{20.0,1.0,28.0,15.0},{28.0,1.0,20.0,15.0},{1.0,28.0,20.0,15.0},{1.0,20.0,28.0,15.0},
{27.0,30.0,63.0,15.0},{30.0,27.0,63.0,15.0},{30.0,63.0,27.0,15.0},{27.0,63.0,30.0,15.0},{63.0,27.0,30.0,15.0},{63.0,30.0,27.0,15.0},
{44.0,1.0,1.0,17.0},{1.0,44.0,1.0,17.0},{1.0,1.0,44.0,17.0},{44.0,1.0,1.0,17.0},{1.0,44.0,1.0,17.0},{1.0,1.0,44.0,17.0},
{44.0,16.0,1.0,6.0},{16.0,44.0,1.0,6.0},{16.0,1.0,44.0,6.0},{44.0,1.0,16.0,6.0},{1.0,44.0,16.0,6.0},{1.0,16.0,44.0,6.0},
{28.0,39.0,20.0,15.0},{39.0,28.0,20.0,15.0},{39.0,20.0,28.0,15.0},{28.0,20.0,39.0,15.0},{20.0,28.0,39.0,15.0},{20.0,39.0,28.0,15.0},
{27.0,39.0,20.0,15.0},{39.0,27.0,20.0,15.0},{39.0,20.0,27.0,15.0},{27.0,20.0,39.0,15.0},{20.0,27.0,39.0,15.0},{20.0,39.0,27.0,15.0},
{27.0,39.0,20.0,15.0},{39.0,27.0,20.0,15.0},{39.0,20.0,27.0,15.0},{27.0,20.0,39.0,15.0},{20.0,27.0,39.0,15.0},{20.0,39.0,27.0,15.0},
{40.0,1.0,1.0,15.0},{1.0,40.0,1.0,15.0},{1.0,1.0,40.0,15.0},{40.0,1.0,1.0,15.0},{1.0,40.0,1.0,15.0},{1.0,1.0,40.0,15.0},
{27.0,39.0,20.0,15.0},{39.0,27.0,20.0,15.0},{39.0,20.0,27.0,15.0},{27.0,20.0,39.0,15.0},{20.0,27.0,39.0,15.0},{20.0,39.0,27.0,15.0},
{53.0,1.0,1.0,18.0},{1.0,53.0,1.0,18.0},{1.0,1.0,53.0,18.0},{53.0,1.0,1.0,18.0},{1.0,53.0,1.0,18.0},{1.0,1.0,53.0,18.0},
{53.0,1.0,1.0,19.0},{1.0,53.0,1.0,19.0},{1.0,1.0,53.0,19.0},{53.0,1.0,1.0,19.0},{1.0,53.0,1.0,19.0},{1.0,1.0,53.0,19.0},
{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},
{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},
{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},
{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},
{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},{47.0,1.0,1.0,19.0},{1.0,47.0,1.0,19.0},{1.0,1.0,47.0,19.0},
{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},{47.0,1.0,1.0,18.0},{1.0,47.0,1.0,18.0},{1.0,1.0,47.0,18.0},
{11.0,17.0,18.0,23.0},{17.0,11.0,18.0,23.0},{17.0,18.0,11.0,23.0},{11.0,18.0,17.0,23.0},{18.0,11.0,17.0,23.0},{18.0,17.0,11.0,23.0},
{11.0,17.0,18.0,24.0},{17.0,11.0,18.0,24.0},{17.0,18.0,11.0,24.0},{11.0,18.0,17.0,24.0},{18.0,11.0,17.0,24.0},{18.0,17.0,11.0,24.0},
{11.0,17.0,18.0,22.0},{17.0,11.0,18.0,22.0},{17.0,18.0,11.0,22.0},{11.0,18.0,17.0,22.0},{18.0,11.0,17.0,22.0},{18.0,17.0,11.0,22.0},
{12.0,4.0,1.0,25.0},{4.0,12.0,1.0,25.0},{4.0,1.0,12.0,25.0},{12.0,1.0,4.0,25.0},{1.0,12.0,4.0,25.0},{1.0,4.0,12.0,25.0},
{12.0,4.0,1.0,26.0},{4.0,12.0,1.0,26.0},{4.0,1.0,12.0,26.0},{12.0,1.0,4.0,26.0},{1.0,12.0,4.0,26.0},{1.0,4.0,12.0,26.0},
{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},
{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},
{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},
{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},{64.0,1.0,1.0,20.0},{1.0,64.0,1.0,20.0},{1.0,1.0,64.0,20.0},
{14.0,1.0,1.0,21.0},{1.0,14.0,1.0,21.0},{1.0,1.0,14.0,21.0},{14.0,1.0,1.0,21.0},{1.0,14.0,1.0,21.0},{1.0,1.0,14.0,21.0},
{14.0,1.0,1.0,21.0},{1.0,14.0,1.0,21.0},{1.0,1.0,14.0,21.0},{14.0,1.0,1.0,21.0},{1.0,14.0,1.0,21.0},{1.0,1.0,14.0,21.0},
{61.0,43.0,42.0,27.0},{43.0,61.0,42.0,27.0},{43.0,42.0,61.0,27.0},{61.0,42.0,43.0,27.0},{42.0,61.0,43.0,27.0},{42.0,43.0,61.0,27.0},
{13.0,1.0,1.0,28.0},{1.0,13.0,1.0,28.0},{1.0,1.0,13.0,28.0},{13.0,1.0,1.0,28.0},{1.0,13.0,1.0,28.0},{1.0,1.0,13.0,28.0},
{44.0,49.0,16.0,17.0},{49.0,44.0,16.0,17.0},{49.0,16.0,44.0,17.0},{44.0,16.0,49.0,17.0},{16.0,44.0,49.0,17.0},{16.0,49.0,44.0,17.0},
{25.0,1.0,1.0,29.0},{1.0,25.0,1.0,29.0},{1.0,1.0,25.0,29.0},{25.0,1.0,1.0,29.0},{1.0,25.0,1.0,29.0},{1.0,1.0,25.0,29.0},
{23.0,1.0,1.0,28.0},{1.0,23.0,1.0,28.0},{1.0,1.0,23.0,28.0},{23.0,1.0,1.0,28.0},{1.0,23.0,1.0,28.0},{1.0,1.0,23.0,28.0},
{54.0,1.0,1.0,29.0},{1.0,54.0,1.0,29.0},{1.0,1.0,54.0,29.0},{54.0,1.0,1.0,29.0},{1.0,54.0,1.0,29.0},{1.0,1.0,54.0,29.0},
{10.0,1.0,1.0,29.0},{1.0,10.0,1.0,29.0},{1.0,1.0,10.0,29.0},{10.0,1.0,1.0,29.0},{1.0,10.0,1.0,29.0},{1.0,1.0,10.0,29.0},
{29.0,1.0,1.0,13.0},{1.0,29.0,1.0,13.0},{1.0,1.0,29.0,13.0},{29.0,1.0,1.0,13.0},{1.0,29.0,1.0,13.0},{1.0,1.0,29.0,13.0},
{32.0,1.0,1.0,13.0},{1.0,32.0,1.0,13.0},{1.0,1.0,32.0,13.0},{32.0,1.0,1.0,13.0},{1.0,32.0,1.0,13.0},{1.0,1.0,32.0,13.0},
{35.0,1.0,1.0,6.0},{1.0,35.0,1.0,6.0},{1.0,1.0,35.0,6.0},{35.0,1.0,1.0,6.0},{1.0,35.0,1.0,6.0},{1.0,1.0,35.0,6.0},
{35.0,1.0,1.0,7.0},{1.0,35.0,1.0,7.0},{1.0,1.0,35.0,7.0},{35.0,1.0,1.0,7.0},{1.0,35.0,1.0,7.0},{1.0,1.0,35.0,7.0},
{8.0,1.0,1.0,6.0},{1.0,8.0,1.0,6.0},{1.0,1.0,8.0,6.0},{8.0,1.0,1.0,6.0},{1.0,8.0,1.0,6.0},{1.0,1.0,8.0,6.0},
{8.0,1.0,1.0,7.0},{1.0,8.0,1.0,7.0},{1.0,1.0,8.0,7.0},{8.0,1.0,1.0,7.0},{1.0,8.0,1.0,7.0},{1.0,1.0,8.0,7.0},
{22.0,1.0,1.0,7.0},{1.0,22.0,1.0,7.0},{1.0,1.0,22.0,7.0},{22.0,1.0,1.0,7.0},{1.0,22.0,1.0,7.0},{1.0,1.0,22.0,7.0},
{3.0,1.0,1.0,30.0},{1.0,3.0,1.0,30.0},{1.0,1.0,3.0,30.0},{3.0,1.0,1.0,30.0},{1.0,3.0,1.0,30.0},{1.0,1.0,3.0,30.0},
{3.0,1.0,1.0,30.0},{1.0,3.0,1.0,30.0},{1.0,1.0,3.0,30.0},{3.0,1.0,1.0,30.0},{1.0,3.0,1.0,30.0},{1.0,1.0,3.0,30.0},
{48.0,41.0,45.0,31.0},{41.0,48.0,45.0,31.0},{41.0,45.0,48.0,31.0},{48.0,45.0,41.0,31.0},{45.0,48.0,41.0,31.0},{45.0,41.0,48.0,31.0}
};

    double uji[] = new double[3];

    String namaObat[][] = {{"Bronsolvan", "Asma", "tukak lambung"},
    {"Asthma-Soho", "Asma", "tukak lambung, hipertiroid, jantung, diabetes, hipertensi"},
    {"Aminophylin", "Asma", "anak berusia kurang dari 12 tahun"},
    {"Asmasolon", "Asma", ""},
    {"Alleron Tablet", "Rhinitis", ""},
    {"Alleron Tablet", "Urtikaria", "alergi ctm, Neonatus"},
    {"Allerzin Syrup", "Alergi", "prornethazine"},
    {"Allerzin Syrup", "Gatal - gatal", "prornethazine"},
    {"Antiza Tablet", "Flu", "gangguan jantung,diabetus melitus, gangguan fungsi hati"},
    {"Bufect Suspensi", "Flu", "Ulkus peptikum, kehamilan"},
    {"Bufect Suspensi", "Inflamasi", "Ulkus peptikum, kehamilan"},
    {"Bromifar Kaplet", "Batuk Berdahak", "anak dibawah 6 tahun"},
    {"Anakonidin Obh", "Flu", "hipertensi parah, penyakit jantung, diabetes mellitus"},
    {"Benacol Dtm Syrup", "Batuk", "Bayi baru lahir, Ibu menyusui"},
    {"Benacol Dtm Syrup", "Alergi", "Bayi baru lahir, Ibu menyusui"},
    {"Bisoltussin Sirup", "Batuk", "anak dibawah 2 tahun, gangguan fungsi hati"},
    {"Bisolvon Tablet", "Batuk Berdahak", ""},
    {"Bronchitin Syrup", "Flu", "hipertensi, glaukoma, diabetik, penyakit jantung dan goiter"},
    {"Calortusin Tablet", "Flu", "jantung dan diabetes melitus, gangguan fungsi hati"},
    {"Camidryl Expectorant", "Flu", "bayi baru lahir"},
    {"Camidryl Expectorant", "Batuk Berdahak", "bayi baru lahir"},
    {"Dextromethorphan", "Batuk", "wanita hamil"},
    {"Inadryl Sirup", "Batuk Berdahak", "bayi baru lahir"},
    {"Konidin", "Asma", ""},
    {"Konidin", "Batuk", ""},
    {"Konidin", "Bronkhitis", ""},
    {"Mixadin", "Flu", "Hipertiroidisme, hipertensi, penyakit koroner"},
    {"Mucotussan", "Flu", "gangguan jantung dan diabetes mellitus"},
    {"Mucotussan", "Batuk", "gangguan jantung dan diabetes mellitus"},
    {"Dexanta", "Hiperasiditas", ""},
    {"Dexanta", "Tukak Lambung", ""},
    {"Decolgen (Flu)", "Flu", "hipertensi berat"},
    {"Bodrex (Flu)", "Flu", ""},
    {"Citocetin (Batuk)", "Flu", ""},
    {"Coldrexin (Flu)", "Flu", ""},
    {"Ambeven", "Wasir", ""},
    {"Konvermex (Cacingan)", "Antelmintik", ""},
    {"Allerin", "Batuk Berdahak", ""},
    {"Dexanta", "Maag", ""},
    {"Tremenza", "Flu", ""},
    {"Bronchitin", "Batuk", "Penderita dengan gangguan jantung dan diabetes melitus"},
    {"Neosma", "Asma", "Penderita gangguan fungsi hati berat, tirotoksikosis, toksemia gravidarum, abortus iminens"},
    {"Salbutamol", "Asma", ""},
    {"Noza", "Flu", "Tidak cocok digunakan untuk anak-anak di bawah 12 tahun, wanita hamil dan menyusui, kecuali atas anjuran dokter"},
    {"Farmadol", "Flu", ""},
    {"Betamol", "Sakit Kepala", ""},
    {"Neogobion", "Anemia", "Akumulasi zat besi, gangguan penggunaan zat besi oleh tubuh"},
    {"Veroscan", "Anemia", ""},
    {"Selesmol", "Sakit Kepala", "Penderita gangguan fungsi hati yang berat"},
    {"Prodol", "Flu", ""},
    {"Emibion", "Anemia", "Ulkus peptikuma aktif, hemokromatosis, anemia hemolitikum, enteritis regional, kolitis ulseratif"},
    {"Cymafort", "Anemia", ""},
    {"Sangovitin", "Anemia", ""},
    {"Ferromia", "Anemia", ""},
    {"Sangofer", "Anemia", ""},
    {"Pantrin", "Infeksi Cacing Kremi", ""},
    {"Pantrin", "Infeksi Cacing Gelang", ""},
    {"Combicitrine", "Infeksi Cacing Kremi", ""},
    {"Combicitrine", "Infeksi Cacing Gelang", ""},
    {"Imarcitrin", "Infeksi Cacing Gelang", ""},
    {"Imarcitrin", "Infeksi Cacing Kremi", ""},
    {"Aficitrin", "Infeksi Cacing Gelang", ""},
    {"Aficitrin", "Infeksi Cacing Kremi", "Gangguan ginjal, gangguan hati, epilepsi, hipersensitif, bayi prematur"},
    {"Dentasol", "Radang Gusi", ""},
    {"Dentasol", "Sariawan", ""},
    {"Dentasol", "Sakit Gigi", ""},
    {"Tantum Verde Solution", "Sakit Tenggorokan", ""},
    {"Tantum Verde Solution", "Tonsilitis", ""},
    {"Zircum Kid", "Diare", ""},
    {"Zanic", "Diare", ""},
    {"Zincare", "Diare", ""},
    {"Orezinc", "Diare", ""},
    {"Stolax", "Konstipasi Akut", ""},
    {"Laxana", "Konstipasi Akut", "Operasi abdomen akut, apendisitis, perdarahan rektal, gastroenteritis"},
    {"Vital Ear Oil", "Sakit Telinga", ""},
    {"Vertex", "Vertigo", "Hipersensitif, penderita feokromositoma"},
    {"Oskadon Migrain", "Sakit Kepala", "Jangan diberikan untuk pasien yang memiliki riwayat hipersensitif terhadap paracetamol, propyphenazone, dan komponen lain obat ini"},
    {"Almen", "Demensia Ringan", "Hipersensitif terhadap derivat piperidin"},
    {"Dimenhidrinat", "Vertigo", ""},
    {"Exelon", "Demensia Ringan", "Kerusakan hati berat, Laktasi"},
    {"Galantamine", "Demensia Ringan", ""},
    {"Ardium® Tablet", "Wasir", "Ardium"},
    {"Mediven", "Wasir", ""},
    {"Ibuprofen", "Flu", ""},
    {"Ibuprofen", "Inflamasi", ""},
    {"Mefinal", "Flu", "tukak lambung dan usus"},
    {"Mefinal", "Inflamasi", "tukak lambung dan usus"},
    {"Cataflam D", "Inflamasi", ""},
    {"Aciclovir", "Herpes", ""},
    {"Temiral", "Herpes", "Hipersensitivitas"},
    {"Polifrisin", "Infeksi Mata", "Hipersensitivitas, glaukoma sudut sempi"}};

    // Method untuk mengubah baris menjadi kolom
    public static double[][] tranpose(double[][] arr) {
        double[][] new_arr = new double[arr[0].length][arr.length];
        for (int i = 0; i < new_arr.length; i++) {
            for (int j = 0; j < new_arr[i].length; j++) {
                new_arr[i][j] = arr[j][i];
            }
        }
        return new_arr;
    }

    //Method untuk mencari nilai terkecil
    public static double min(double[] arr) {
        double min = Double.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (min > arr[i]) {
                min = arr[i];
            }
        }
        return min;
    }

    //Method untuk mencari nilai terbesar
    public static double max(double[] arr) {
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    public static double max_data(double[] arr) {
        double k = 0;
        double max = Double.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
                k = i;
            }
        }
        return k;
    }

    //Method normaliasasi data dari array
    public static double[][] normalisasi(double[][] data) {
        double[][] nu_data = tranpose(data);
        for (double[] d : nu_data) {
            double min = min(d);
            double max = max(d);
            for (int i = 0; i < d.length; i++) {
                if (max == min) {
                    d[i] = 1;
                } else {
                    d[i] = (d[i] - min) / (max - min);
                }
            }
        }
        return tranpose(nu_data);
    }

    //Method normalisasi data inputan user
    public static double[] normalisasi(double[][] data, double[] input) {
        double[][] nu_data = tranpose(data);
        double[] min = new double[nu_data.length];
        double[] max = new double[nu_data.length];
        for (int i = 0; i < min.length; i++) {
            min[i] = min(nu_data[i]);
            max[i] = max(nu_data[i]);
        }
        double[] nu_input = new double[input.length];
        System.arraycopy(input, 0, nu_input, 0, input.length);//mencopy data 
        for (int i = 0; i < nu_input.length; i++) {
            nu_input[i] = (nu_input[i] - min[i]) / (max[i] - min[i]);
        }
        return nu_input;
    }

    //method mencari encludian vektor
    public static double encludian(double[] v1, double[] v2) {
        double e = 0;
        for (int i = 0; i < v1.length; i++) {
            e += Math.pow(v1[i] - v2[i], 2);
        }
        return Math.sqrt(e);
    }

    public static double[] encludian_vek(double[] input, double[][] data) {
        double[] vek_enc = new double[data.length];
        for (int i = 0; i < vek_enc.length; i++) {
            vek_enc[i] = 1 / Math.pow(encludian(input, data[i]), 2);
        }
        return vek_enc;
    }

    //Method untuk mengelompokan data
    public static HashMap<Double, Double> reduce(double[] e, double[][] data) {
        HashMap<Double, Double> map = new HashMap<>();
        for (int i = 0; i < e.length; i++) {
            if (map.containsKey(data[i][3])) {
                map.replace(data[i][3], map.get(data[i][3]) + e[i]);
            } else {
                map.put(data[i][3], e[i]);
            }
        }
        return map;
    }

    public String cari(double[] uji, double[][] data) {
        double[][] new_data = normalisasi(data);
        double[] new_uji = normalisasi(data, uji);

        double data_baru[] = new double[91];
        double data_kat[] = new double[91];
        int count = 0;
        double[] vek_distance = knn.encludian_vek(new_uji, new_data);
     
        HashMap<Double, Double> hasil = reduce(vek_distance, data);
        HashMap<Double, String> Kat = new HashMap<>();
        Kat.put(1d, "Asma");
        Kat.put(2d, "Rhinitis");
        Kat.put(3d, "Urtikaria");
        Kat.put(4d, "Alergi");
        Kat.put(5d, "Gatal - gatal");
        Kat.put(6d, "Flu");
        Kat.put(7d, "Inflamasi");
        Kat.put(8d, "Batuk Berdahak");
        Kat.put(9d, "Batuk");
        Kat.put(10d, "Bronkhitis");
        Kat.put(11d, "Hiperasiditas");
        Kat.put(12d, "Tukak Lambung");
        Kat.put(13d, "Wasir");
        Kat.put(14d, "Maag");
        Kat.put(15d, "Anemia");
        Kat.put(16d, "Antelmintik");
        Kat.put(17d, "Sakit Kepala");
        Kat.put(18d, "Infeksi Cacing Kremi");
        Kat.put(19d, "Infeksi Cacing Gelang");
        Kat.put(20d, "Diare");
        Kat.put(21d, "Konstipasi Akut");
        Kat.put(22d, "Sakit Gigi");
        Kat.put(23d, "Radang Gusi");
        Kat.put(24d, "Sariawan");
        Kat.put(25d, "Sakit Tenggorokan");
        Kat.put(26d, "Tonsilitis");
        Kat.put(27d, "Sakit Telinga");
        Kat.put(28d, "Vertigo");
        Kat.put(29d, "Demensia Ringan");
        Kat.put(30d, "Herpes");
        Kat.put(31d, "Infeksi Mata");
        System.out.println("");
        hasil.forEach((key, value) -> {
            System.out.println(Kat.get(key) + ", " + value);
        });
        for (Map.Entry me : hasil.entrySet()) {
            //System.out.println("Key: "+me.getKey() + " & Value: " + me.getValue());
            data_kat[count] = (double) me.getKey();
            data_baru[count] = (double) me.getValue();
            count++;
        }
        double data_hasil = max_data(data_baru);
        String gejala = " ";
        
        if (data_hasil == 0.0) {
            gejala = "Rhintis";
        }
        else if (data_hasil == 1.0) {
            gejala = "Urtikaria";
        } else if (data_hasil == 2.0) {
            gejala = "Alergi";
        } else if (data_hasil == 3.0) {
            gejala = "Gatal - Gatal";
        } else if (data_hasil == 4.0) {
            gejala = "Flu";
        } else if (data_hasil == 5.0) {
            gejala = "Inflamasi";
        } else if (data_hasil == 6.0) {
            gejala = "Batuk Berdahak";
        } else if (data_hasil == 7.0) {
            gejala = "Batuk";
        } else if (data_hasil == 8.0) {
            gejala = "Bronkhitis";
        } else if (data_hasil == 9.0) {
            gejala = "Hiperasiditas";
        } else if (data_hasil == 10.0) {
            gejala = "Tukak Lambung";
        } else if (data_hasil == 11.0) {
            gejala = "Wasir";
        } else if (data_hasil == 12.0) {
            gejala = "Maag";
        } else if (data_hasil == 13.0) {
            gejala = "Anemia";
        } else if (data_hasil == 14.0) {
            gejala = "Asma";
        } else if (data_hasil == 15.0) {
            gejala = "Antelmintik";
        } else if (data_hasil == 16.0) {
            gejala = "Sakit Kepala";
        } else if (data_hasil == 17.0) {
            gejala = "Infeksi Cacing Kremi";
        } else if (data_hasil == 18.0) {
            gejala = "Infeksi Cacing Gelang";
        } else if (data_hasil == 19.0) {
            gejala = "Diare";
        } else if (data_hasil == 20.0) {
            gejala = "Konstipasi Akut";
        } else if (data_hasil == 21.0) {
            gejala = "Sakit Gigi";
        } else if (data_hasil == 22.0) {
            gejala = "Radang Gusi";
        } else if (data_hasil == 23.0) {
            gejala = "Sariawan";
        } else if (data_hasil == 24.0) {
            gejala = "Sakit Tenggorokan";
        } else if (data_hasil == 25.0) {
            gejala = "Tonsilitis";
        } else if (data_hasil == 26.0) {
            gejala = "Sakit Telinga";
        } else if (data_hasil == 27.0) {
            gejala = "Vertigo";
        } else if (data_hasil == 28.0) {
            gejala = "Demensia Ringan";
        } else if (data_hasil == 29.0) {
            gejala = "Herpes";
        } else if (data_hasil == 30.0) {
            gejala = "Infeksi Mata";
        }
        System.out.println(data_hasil);
        return gejala;
    }

}
