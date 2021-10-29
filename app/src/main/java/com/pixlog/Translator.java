package com.pixlog;

public class Translator {

    private Boolean[] languages = new Boolean[3];

    public Translator(){
    }

    public void setLanguage(Integer langId) {
        if (langId == 0) languages = new Boolean[]{true,false,false}; //portugues
        else if (langId == 1) languages = new Boolean[]{false,true,false}; //ingles
        else if (langId == 2) languages = new Boolean[]{false,false,true}; //espanhol
    }

    private String Translate(String portuguese, String english, String spanish) {
        String text = "";

        if (null == languages[0] && null == languages[1] && null == languages[2]) {
            text = portuguese;
        } else {
            if (languages[0] && !languages[1] && !languages[2]) {
                text = portuguese;
            } else if (!languages[0] && languages[1] && !languages[2]) {
                text = english;
            } else if (!languages[0] && !languages[1] && languages[2]) {
                text = spanish;
            }
        }

        return text;
    }

    public String touch2Detect() {
        return Translate("Toque para iniciar",
                "Touch to start",
                "Toca para empezar");
    }


    public String noPermissions() {
        return Translate("Permissões não concedidas pelo usuário",
                "Permissions not granted by the user",
                "Permisos no otorgados por el usuario");
    }


    public String UserName() {
        return Translate("Usuário",
                "Username",
                "Usuario");
    }

    public String TypeUserName() {
        return Translate("Digite seu e-mail",
                "Type your e-mail",
                "Escribe tu e-mail");
    }

    public String RecoverUsername() {
        return Translate("Recuperar e-mail",
                "Recover e-mail",
                "Recuperar e-mail");
    }

    public String Password() {
        return Translate("Senha",
                "Password",
                "Contraseña");
    }

    public String TypePassword() {
        return Translate("Digite sua senha",
                "Type your password",
                "Escribe tu contraseña");
    }

    public String RecoverPassword() {
        return Translate("Recuperar senha",
                "Recover password",
                "Recuperar contraseña");
    }

    public String TxtCreateAccount() {
        return Translate("Precisa de uma conta?",
                "Don't you have an account?",
                "¿No tiene una cuenta?");
    }

    public String CreateAccount() {
        return Translate("CADASTRE-SE",
                "CREATE ONE",
                "CREAR UNA");
    }

    public String login(){
        return Translate("Entrar",
                "Log in",
                "Ingresar");
    }

    public String License() {
        return Translate("Licença",
                "License",
                "Licencia");
    }

    public String Status() {
        return Translate("Estado",
                "Status",
                "Estado");
    }

    public String Active() {
        return Translate("Ativo",
                "Active",
                "Activo");
    }

    public String Inactive() {
        return Translate("Inativo",
                "Inactive",
                "Inactivo");
    }

    public String Yes(){
        return Translate("Sim", "Yes", "Sí");
    }

    public String No(){
        return Translate("Não", "No", "No");
    }

    public String data(){
        return Translate("Data", "Date", "Fecha");
    }

    public String hora(){
        return Translate("Hora", "Hour", "Hora");
    }

    public String inclinacao() {
        return Translate("Inclinação do dispositivo",
                "Device inclination",
                "Inclinación del dispositivo");
    }

    public String DeleteCurrent(){
        return Translate("O trabalho atual será excluído, deseja continuar?",
                "The current work will be excluded. Do you really want to continue?",
                "El trabajo actual será excluido, ¿realmente quieres continuar?");
    }

    public String latitude(){
        return Translate("Latitude",
                "Latitude",
                "Latitud");
    }

    public String longitude(){
        return Translate("Longitude",
                "Longitude",
                "Longitud");
    }

    public String imgsIntent(){
        return Translate("Nenhuma imagem encontrada",
                "No images found",
                "No se encontraron imágenes");
    }

    public String NoLogs(){
        return Translate("Nenhuma tora detectada",
                "No logs detected",
                "No se detectaron trozas");
    }

    public String PicsNotEnough(){
        return Translate("Número de fotos insuficiente",
                "Not enough number of images",
                "No hay suficiente cantidad de imágenes");
    }

    public String CameraPermission(){
        return Translate("Este app necessita da permissão da câmera",
                "This app needs camera permission",
                "Esta aplicación necesita permiso de la cámara");
    }

    public String CameraError(){
        return Translate("Este dispositivo não suporta a API da câmera",
                "This device does not support camera API",
                "Este dispositivo no admite API de cámara");
    }

    public String Failed(){
        return Translate("Falhou", "Failed", "Fallado");
    }

    public String Cancel(){
        return Translate("Cancelar", "Cancel", "Cancelar");
    }

    public String appEmail(){
        return Translate("Escolha um app de e-mail",
                "Choose an e-mail app",
                "Elige un app de correo electrónico");
    }

    public String ReportTitle(){
        return Translate("Relatório de medição de toras",
                "Timber measurement report",
                "Informe de medición de trozas");
    }

    public String relatorioInfos05(){
        return Translate("Análise estatística - Diâmetro",
                "Statistical analysis - Diameter",
                "Análisis estadístico - Diámetro");
    }

    public String relatorioInfos06(){
        return Translate("Análise estatística - Volumetria",
                "Statistical analysis - Volumetry",
                "Análisis estadístico - Volumetría");
    }

    public String relatorioInfos07(){
        return Translate("Dados completos",
                "Complete data",
                "Datos completos");
    }

    public String descricao(){
        return Translate("Descrição","Description","Descripción");
    }

    public String Value(){
        return Translate("Valor","Value","Valor");
    }

    public String Avg(){
        return Translate("Média", "Average","Promedio");
    }

    public String Min(){
        return Translate("Mínimo","Minimum","Mínimo");
    }

    public String Max(){
        return Translate("Máximo", "Maximum","Maximo");
    }

    public String Total(){
        return Translate("Total", "Amount","Cantidad");
    }

    public String Std(){
        return Translate("Desvio padrão",
                "Standard deviation",
                "Desviacion estandar");
    }

    public String Variance(){
        return Translate("Variância",
                "Variance",
                "Varianza");
    }

    public String Median(){
        return Translate("Mediana",
                "Median",
                "Mediana");
    }

    public String Mode(){
        return Translate("Moda", 
                "Mode",
                "Moda");
    }

    public String Sum(){
        return Translate("Soma",
                "Sum",
                "Suma");
    }

    public String Diameter(){
        return Translate("Diâmetro",
                "Diameter",
                "Diámetro");
    }

    public String Volume(){
        return Translate("Volume",
                "Volume",
                "Volumen");
    }

    public String volCalc(){
        return Translate("Cálculo do volume",
                "Volume calculation",
                "Cálculo de volumen");
    }

    public String LogSpecie(){
        return Translate("Espécies encontradas",
                "Wood specie found",
                "Especies encontradas");
    }

    public String VolumeFormula01(){
        return Translate("fórmula cilíndrica",
                "cylindrical formula",
                "fórmula cilíndrica");
    }

    public String VolumeFormula02(){
        return Translate("escala JAS",
                "JAS scale",
                "escala JAS");
    }

    public String VolumeFormula03(){
        return Translate("GOST 2708-75",
                "GOST 2708-75",
                "GOST 2708-75");
    }

    public String VolumeFormula04(){
        return Translate("regra Doyle",
                "Doyle log rule",
                "regla de Doyle");
    }

    public String VolumeFormula05(){
        return Translate("regra internacional 1/4\"",
                "1/4\" international log scale",
                "regla internacional 1/4\"");
    }

    public String VolumeFormula06(){
        return Translate("regra de Roy",
                "roy log rule",
                "regla de Roy");
    }

    public String VolumeFormula07(){
        return Translate("scribner Decimal C",
                "scribner Decimal C",
                "scribner Decimal C");
    }

    public String VolumeFormula08(){
        return Translate("regra de medição ontario",
                "ontario measurement rule",
                "regla de medición de Ontario");
    }

    public String VolumeFormula09(){
        return Translate("sistema lituano",
                "lithuanian system",
                "sistema lituano");
    }

    public String VolumeFormula10(){
        return Translate("sistema lituano com casca",
                "lithuanian system with bark",
                "sistema lituano con cáscara");
    }

    public String VolumeFormula11(){
        return Translate("padrão letão",
                "latvian standard",
                "estándar letón");
    }

    public String VolumeFormula12(){
        return Translate("fórmula A. Nilson",
                "A. Nilson formula",
                "fórmula A. Nilson");
    }

    public String VolumeFormula13(){
        return Translate("hoppus imperial",
                "imperial hoppus",
                "hoppus imperial");
    }

    public String VolumeFormula14(){
        return Translate("hoppus métrico",
                "metrical hoppus",
                "hoppus métrico");
    }

    public String VolumeFormula15(){
        return Translate("padrão sul-africano",
                "south african standard",
                "estándar sudafricano");
    }

    public String DIB(){
        return Translate("DAP",
                "DIB",
                "DAP");
    }

    public String Added(boolean plural) {
        if (!plural){
            return Translate("adicionada",
                    "added",
                    "agregada");
        } else {
            return Translate("adicionadas",
                    "added",
                    "agregadas");
        }
    }

    public String OpenPDF() {
        return Translate("Escolha um app para abrir o PDF",
                "Choose an app to open the PDF",
                "Elija una aplicación para abrir el PDF");
    }

    public String NoInternet() {
        return Translate("Sem conexão com a internet",
                "No internet conection",
                "Sin conexión a Internet");
    }

    public String Credits() {
        return Translate("Créditos",
                "Credits",
                "Créditos");
    }

    public String Logs() {
        return Translate("Toras",
                "Logs",
                "Trozas");
    }

    public String YourData() {
        return Translate("Seus dados",
                "Your data",
                "Sus datos");
    }

    public String Logout() {
        return Translate("Desconectar",
                "Log out",
                "Cerrar");
    }

    public String VolumeFormula() {
        return Translate("Fórmula de volume",
                "Volume formula",
                "Fórmula de volumen");
    }

    public String Exit(){
        return Translate("Deseja realmente sair?",
                "Are you sure to log out?",
                "¿Estás seguro de cerrar sesión?");
    }

    public String MandatoryFiling() {
        return Translate("É obrigatório o preenchimento de todos os campos acima",
                "It's mandatory filling all the field above",
                "Es obligatorio llenar todo el campo de arriba.");
    }

    public String Finished() {
        return Translate("Medição de toras concluída com sucesso!",
                "Timber measurement successfully completed!",
                "¡Medición de madera completada con éxito!");
    }

    public String Processing(){
        return Translate("Processando", "Processing", "Procesando");

    }

    public String Info2Mes_ref() {
        return Translate("Comprimento do objeto de referência",
                "Reference object length",
                "Longitud del objeto de referencia");
    }

    public String Info2Mes_comp() {
        return Translate("Comprimento das toras",
                "Logs length",
                "Longitud de trozas");
    }

    public String ScaleOutOfBounds() {
        return Translate("Barra de escala fora da imagem",
                "Scale bar out of image bounds",
                "Barra de escala fuera de los límites de la imagen");
    }

    public String NoImgPicked() {
        return Translate("Nenhuma imagem selecionada",
                "No image picked",
                "No se recogió ninguna imagen");
    }

    public String ErrorPickingImg() {
        return Translate("Erro ao selecionar imagem",
                "Error when picking up image",
                "Error al recoger la imagen");
    }

    public String OneMoment() {
        return Translate("Um momento...",
                "A moment...",
                "Un momento...");
    }

    public String AreYouSure() {
        return Translate("Tem certeza?",
                "Are you sure?",
                "¿Estas seguro?");
    }

    public String EditionFinished(){
        return Translate("Edição concluída",
                "Edition finished",
                "Edición terminada");
    }

    public String TFproblem() {
        return Translate("Problema ao iniciar detecção",
                "Problem initializing detection",
                "Problema al iniciar la detección");
    }

    public String LoginProblem() {
        return Translate("Problema ao conectar o usuário",
                "Problem logging user in",
                "Problema al iniciar sesión");
    }

    public String NoCredits() {
        return Translate("Não há créditos disponíveis",
                "No credits available",
                "No hay créditos disponibles");
    }

    public String UnitsSet() {
        return Translate("Nova fórmula de volume definida",
                "New volume formula defined",
                "Nueva fórmula de volumen definida");
    }

    public String Cliente() {
        return Translate("Cliente","Client","Cliente");
    }

    public String Origin() {
        return Translate("Origem","Origin","Origen");
    }

    public String Destination(){
        return Translate("Destino da carga","Cargo destination","Destino de carga");
    }

    public String Name() {
        return Translate("Nome",
                "Name",
                "Nombre");
    }

    public String Location() {
        return Translate("Localização",
                "Location",
                "Ubicación");
    }

    public String Company() {
        return Translate("Empresa",
                "Company",
                "Empresa");
    }

    public String Register() {
        return Translate("Registrar-se",
                "Register",
                "Registrarse");
    }

    public String Accept() {
        return Translate("Eu li e concordo com os",
                "I've read and agree with the",
                "He leído y estoy de acuerdo con los");
    }

    public String TermsConditions() {
        return Translate("termos e condições",
                "terms and conditions",
                "términos y Condiciones");
    }

    public String ChangedToPort() {
        return Translate("Idioma definido como Português",
                "Language set as Portuguese",
                "Idioma establecido como portugués");
    }

    public String ChangedToEng() {
        return Translate("Idioma definido como Inglês",
                "Language set as English",
                "Idioma establecido como Inglés");
    }

    public String ChangedToEsp() {
        return Translate("Idioma definido como Espanhol",
                "Language set as Spanish",
                "Idioma establecido como Español");
    }

    public String Pics1() {
        return Translate("foto",
                "picture",
                "imagen");
    }

    public String Pics2() {
        return Translate("fotos",
                "pictures",
                "imagenes");
    }

    public String SingleImgeOn() {
        return Translate("Modo imgem única ativado",
                "Single image mode activated",
                "Modo de imagen única activado");
    }

    public String ImgStitchingOn() {
        return Translate("Modo mosaico ativado",
                "Image stitching mode activated",
                "Modo de unión de imagen activado");
    }

    public String SelectAll() {
        return Translate("Selecionar tudo",
                "Select all",
                "Seleccionar todo");
    }

    public String DeselectAll() {
        return Translate("Deselecionar tudo",
                "Deselect all",
                "Deseleccionar todo");
    }

    public String Export() {
        return Translate("Exportar",
                "Export",
                "Exportar");
    }

    public String Reports() {
        return Translate("Relatórios",
                "Reports",
                "Informes");
    }

    public String NoPDFviewer() {
        return Translate("Por favor, instale um app para visualizar um arquivo PDF",
                "Please install an app to visualize a PDF file",
                "Instale una aplicación para visualizar un archivo PDF");
    }

    public String PerMonth() {
        return Translate("assinatura mensal","monthly subscription","suscripción mensual");
    }

    public String PerYear() {
        return Translate("assinatura anual","annual subscription","suscripción anual");
    }

    public String DevAccount() {
        return Translate("desenvolvedor","developer","desarrollador");
    }

    public String LastPayment() {
        return Translate("Último pagamento","Last payment","Último pago");
    }

    public String AccountChange() {
        return Translate("Para mudanças na conta, contate-nos",
                "For any account change, please contact us",
                "Para cualquier cambio de cuenta, contáctenos");
    }

    public String DoesNotApplyForYou() {
        return Translate("Não se aplica","Not applicable","No se aplica");
    }

    public String ChooseAnOption() {
        return Translate("Escolha uma opção", "Choose an option", "Elija una opción");
    }

    public String Buy() {
        return Translate("Comprar","Buy","Comprar");
    }

    public String SelectAnOptionABove() {
        return Translate("Por favor, escolha uma quantidade acima",
                "Please choose an option above",
                "Por favor elija una opción");
    }

    public String VolumeFormulaChanged() {
        return Translate("Fórmula de volume alterada",
                "Volume formula changed",
                "Fórmula de volumen modificada");
    }

    public String LocationOk() {
        return Translate("Localização OK","Location Ok","Ubicación OK");
    }

    public String ReadPermission() {
        return Translate("É necessária permissão para acessar a galeria",
                "This permission is mandatory to read from gallery",
                "Este permiso es obligatorio para leer desde la galería");
    }

    public String ErrorDeleting() {
        return Translate("Erro ao apagar arquivos",
                "Error deleting files",
                "Error al eliminar archivos");
    }

    public String AccountInfo() {
        return Translate("Apenas preencha se for uma conta para empresas",
                "Just fill it if this account is for a company",
                "Solo complételo si esta cuenta es para una empresa");
    }

    public String Pile() {
        return Translate("Pilha","Pile","Pila");
    }

    public String FillNewName() {
        return Translate("Informe um nome",
                "Type a name",
                "Escriba un nombre");
    }

    public String FolderAlreadyExists() {
        return Translate("Já exite uma pasta com esse nome",
                "There is already a folder with this name",
                "Ya existe una carpeta con ese nombre");
    }

    public String backDialog() {
        return Translate("Voltar",
                "Back",
                "Regresar");
    }

    public String NoResultsYet() {
        return Translate("Sem resultados no momento",
                "No results by now",
                "No hay resultados por ahora");
    }

    public String SuccessfullyRenamed() {
        return Translate("Renomeado com sucesso!",
                "Successfully renamed!",
                "¡Renombrado exitosamente!");
    }

    public String NotRenamed() {
        return Translate("Problema ao renomear",
                "Problem to rename it",
                "Problema para cambiarle el nombre");
    }

    public String SuccessfullyDeleted() {
        return Translate("Apagado com sucesso!",
                "Successfully removed!",
                "¡Eliminado con éxito!");
    }

    public String NotDeleted() {
        return Translate("Problema ao apagar",
                "Problem deleting it",
                "Problema al eliminarlo");
    }

    public String SuccessfullyMoved() {
        return Translate("Movido com sucesso!",
                "Successfully moved!",
                "¡Movido con éxito!");
    }

    public String NotMoved() {
        return Translate("Item não movido","It has not been moved","No ha sido movido");
    }

    public String AlreadyExists() {
        return Translate("Este nome já está em uso, digite outro",
                "This name is already been used, please choose other",
                "Este nombre ya se ha utilizado, elija otro");
    }

    public String NothingToExport() {
        return Translate("Nada para exportar",
                "Nothing to export",
                "Nada que exportar");
    }

    public String ChooseNewFolder() {
        return Translate("Escolha uma nova pasta",
                "Choose a new directory",
                "Elige un nuevo directorio");
    }

    public String ChooseAnotherFOlder() {
        return Translate("Esta é a pasta atual, escolha outra",
                "This is the current folder, choose another one",
                "Esta es la carpeta actual, elige otra");
    }

    public String NotExported() {
        return Translate("Problema ao exportar",
                "Problem to export it",
                "Problema para exportarlo");
    }

    public String InvalidCharacters() {
        return Translate("Há caracteres inválidos no nome escolhido",
                "There are invalid characters in the chosen name",
                "Hay caracteres no válidos en el nombre elegido");
    }

    public String Rename() {
        return Translate("Renomear","Rename","Renombrar");
    }

    public String Move() {
        return Translate("Mover","Move","Mover");
    }

    public String Delete() {
        return Translate("Excluir","Delete","Eliminar");
    }

    public String MoveItem() {
        return Translate("Mova para um local existene ou crie um novo",
                "Move to an existing place or create a new one",
                "Moverse a un lugar existente o crear uno nuevo");
    }

    public String ExistingOne() {
        return Translate("Existente","Existing one","Existente");
    }

    public String CreateNew() {
        return Translate("Criar novo","Create new","Crear nuevo");
    }

    public String Change() {
        return Translate("Mudar","Change","Cambiar");
    }

    public String NewPassword() {
        return Translate("Nova senha","New password","Nueva contraseña");
    }

    public String ConfirmPassword() {
        return Translate("Confirme-a","Confirm it","Confirmarlo");
    }

    public String Updated() {
        return Translate("Atualizado com sucesso","Updated successfully","Actualizado con exito");
    }

    public String NoPDF() {
        return Translate("Relatório não encontrado",
                "Report was not found",
                "No se encontró el informe");
    }

    public String EmptyFolder() {
        return Translate("Pasta vazia","Empty folder","Carpeta vacía");
    }

    public String PlaceToSave() {
        return Translate("Escolha um local para continuar",
                "Choose a place to continue",
                "Elige un lugar para continuar");
    }

    public String NewPlace() {
        return Translate("Novo local","New place","Nuevo lugar");
    }


}
